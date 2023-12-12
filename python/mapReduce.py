from functools import reduce
from operator import itemgetter

# Sample list of documents
documents = [
    "Hello world",
    "Python is awesome",
    "Hello Python",
    "MapReduce in Python",
    "Python programming",
]

# Step 1: Map - Tokenize each document and emit (word, 1) pairs
def map_function(document):
    words = document.lower().split()
    return [(word, 1) for word in words]

mapped_results = map(map_function, documents)

# Flatten the list of (word, 1) pairs
flattened_results = [pair for sublist in mapped_results for pair in sublist]

# Step 2: Shuffle and Sort - Sort by the key (word)
sorted_results = sorted(flattened_results, key=itemgetter(0))

# Step 3: Reduce - Aggregate counts for each word
def reduce_function(result_dict, pair):
    word, count = pair
    result_dict[word] = result_dict.get(word, 0) + count
    return result_dict

word_count = reduce(reduce_function, sorted_results, {})

# Display the final word count
print("Word Count:")
for word, count in word_count.items():
    print(f"{word}: {count}")
