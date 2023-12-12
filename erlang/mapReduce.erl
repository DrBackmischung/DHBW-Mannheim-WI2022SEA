-module(mapreduce).
-export([start/0, map_reduce/1]).

% Step 1: Map - Tokenize each document and emit {word, 1} pairs
map_function(Document) ->
    Words = string:tokens(string:to_lower(Document), " "),
    [{Word, 1} || Word <- Words].

% Step 2: Shuffle and Sort - Sort by the key (word)
sort_results(Results) ->
    lists:keysort(1, Results).

% Step 3: Reduce - Aggregate counts for each word
reduce_function({Word, Counts}) ->
    {Word, lists:sum(Counts)}.

% Worker process for mapping
map_worker(Documents) ->
    MappedResults = lists:flatten(lists:map(fun map_function/1, Documents)),
    SortedResults = sort_results(MappedResults),
    {self(), SortedResults}.

% Worker process for reducing
reduce_worker(SortedResults) ->
    ReducedResults = lists:map(fun reduce_function/1, SortedResults),
    {self(), ReducedResults}.

% Master process coordinating the MapReduce
master(Documents) ->
    % Split documents among map workers
    MapWorkers = [spawn(mapreduce, map_worker, [Chunk]) || Chunk <- lists:split(length(Documents) div 2, Documents)],

    % Collect mapped results from map workers
    MappedResults = lists:flatten([receive {Worker, Results} -> Results end || Worker <- MapWorkers]),

    % Shuffle and Sort
    SortedResults = sort_results(MappedResults),

    % Split sorted results among reduce workers
    ReduceWorkers = [spawn(mapreduce, reduce_worker, [Chunk]) || Chunk <- lists:split(length(SortedResults) div 2, SortedResults)],

    % Collect reduced results from reduce workers
    ReducedResults = lists:flatten([receive {Worker, Results} -> Results end || Worker <- ReduceWorkers]),

    % Display the final word count
    io:format("Word Count: ~p~n", [ReducedResults]).

% Entry point
start() ->
    Documents = ["Hello world",
                 "Erlang is awesome",
                 "Hello Erlang",
                 "MapReduce in Erlang",
                 "Erlang programming"],
    master(Documents).
