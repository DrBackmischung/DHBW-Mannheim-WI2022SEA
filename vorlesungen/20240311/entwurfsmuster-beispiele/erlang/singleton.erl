-module(singleton).
-export([start/0, get_instance/0, add_value/1, get_values/0]).

start() ->
    spawn(fun() -> init([]) end).

init(State) ->
    loop(State).

loop(State) ->
    receive
        {From, add_value(Value)} ->
            NewState = [Value | State],
            From ! {ok, Value},
            loop(NewState);

        {From, get_values} ->
            From ! {ok, State},
            loop(State);

        _ ->
            loop(State)
    end.

get_instance() ->
    Pid = start(),
    {ok, Pid}.

add_value(Value) ->
    Instance = get_instance(),
    Instance ! {self(), add_value(Value)},
    receive
        {ok, _} ->
            ok
    end.

get_values() ->
    Instance = get_instance(),
    Instance ! {self(), get_values},
    receive
        {ok, Values} ->
            Values
    end.