object MapReduceExample extends App {
  // Step 1: Map - Tokenize each document and emit (word, 1) pairs
  def mapFunction(document: String): List[(String, Int)] =
    document.toLowerCase.split("\\s+").map(word => (word, 1)).toList

  // Step 2: Shuffle and Sort - Sort by the key (word)
  def sortResults(results: List[(String, Int)]): List[(String, Int)] =
    results.sortBy(_._1)

  // Step 3: Reduce - Aggregate counts for each word
  def reduceFunction(pair: (String, List[Int])): (String, Int) =
    (pair._1, pair._2.sum)

  // Worker process for mapping
  def mapWorker(documents: List[String]): List[(String, Int)] = {
    val mappedResults = documents.flatMap(mapFunction)
    val sortedResults = sortResults(mappedResults)
    sortedResults
  }

  // Worker process for reducing
  def reduceWorker(sortedResults: List[(String, Int)]): List[(String, Int)] = {
    val groupedResults = sortedResults.groupBy(_._1)
    val reducedResults = groupedResults.map(reduceFunction).toList
    reducedResults
  }

  // Master process coordinating the MapReduce
  def master(documents: List[String]): List[(String, Int)] = {
    // Split documents among map workers
    val mapWorkers = List(documents.take(documents.length / 2), documents.drop(documents.length / 2))
      .map(chunk => mapWorker(chunk))

    // Collect mapped results from map workers
    val mappedResults = mapWorkers.flatten

    // Shuffle and Sort
    val sortedResults = sortResults(mappedResults)

    // Split sorted results among reduce workers
    val reduceWorkers = List(sortedResults.take(sortedResults.length / 2), sortedResults.drop(sortedResults.length / 2))
      .map(chunk => reduceWorker(chunk))

    // Collect reduced results from reduce workers
    val reducedResults = reduceWorkers.flatten

    // Display the final word count
    reducedResults
  }

  // Example usage
  val documents = List(
    "Hello world",
    "Scala is awesome",
    "Hello Scala",
    "MapReduce in Scala",
    "Scala programming"
  )

  val finalResult = master(documents)
  println("Word Count:")
  finalResult.foreach(println)
}
