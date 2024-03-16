defmodule MapReduceExample do
  # Step 1: Map - Tokenize each document and emit {word, 1} pairs
  def map_function(document) do
    document
    |> String.downcase()
    |> String.split(~r/\s+/)
    |> Enum.map(fn word -> {word, 1} end)
  end

  # Step 2: Shuffle and Sort - Sort by the key (word)
  def sort_results(results) do
    Enum.sort(results, fn {word1, _}, {word2, _} -> word1 <= word2 end)
  end

  # Step 3: Reduce - Aggregate counts for each word
  def reduce_function({word, counts}) do
    {word, Enum.sum(counts)}
  end

  # Worker process for mapping
  def map_worker(documents) do
    mapped_results =
      documents
      |> Enum.flat_map(&map_function/1)
    sort_results(mapped_results)
  end

  # Worker process for reducing
  def reduce_worker(sorted_results) do
    grouped_results =
      sorted_results
      |> Enum.group_by(fn {word, _} -> word end)
    Enum.map(grouped_results, &reduce_function/1)
  end

  # Master process coordinating the MapReduce
  def master(documents) do
    # Split documents among map workers
    {map_chunk1, map_chunk2} = Enum.split(documents, div(Enum.count(documents), 2))
    map_workers = [map_chunk1, map_chunk2] |> Enum.map(&map_worker/1) |> Enum.flatten()

    # Shuffle and Sort
    sorted_results = sort_results(map_workers)

    # Split sorted results among reduce workers
    {reduce_chunk1, reduce_chunk2} = Enum.split(sorted_results, div(Enum.count(sorted_results), 2))
    reduce_workers = [reduce_chunk1, reduce_chunk2] |> Enum.map(&reduce_worker/1) |> Enum.flatten()

    # Display the final word count
    reduce_workers
  end
end

# Example usage
documents = [
  "Hello world",
  "Elixir is awesome",
  "Hello Elixir",
  "MapReduce in Elixir",
  "Elixir programming"
]

final_result = MapReduceExample.master(documents)
IO.puts("Word Count:")
Enum.each(final_result, &IO.inspect/1)
