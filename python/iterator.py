# Aggregate class
class MyCollection:
    def __init__(self):
        self._data = []

    def add_item(self, item):
        self._data.append(item)

    def __iter__(self):
        return MyIterator(self._data)


# Iterator class
class MyIterator:
    def __init__(self, data):
        self._data = data
        self._index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self._index < len(self._data):
            result = self._data[self._index]
            self._index += 1
            return result
        else:
            raise StopIteration


# Client code
if __name__ == "__main__":
    collection = MyCollection()
    collection.add_item("Item 1")
    collection.add_item("Item 2")
    collection.add_item("Item 3")

    # Using the iterator to access elements
    iterator = iter(collection)
    for item in iterator:
        print(item)
