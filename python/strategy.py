from typing import List

# Strategie-Interface
class SortStrategy:
    def sort(self, array: List[int]) -> None:
        pass

# Konkrete Strategien
class BubbleSortStrategy(SortStrategy):
    def sort(self, array: List[int]) -> None:
        print("Sorting using Bubble Sort")
        n = len(array)
        swapped = True
        while swapped:
            swapped = False
            for i in range(1, n):
                if array[i - 1] > array[i]:
                    # Swap array[i-1] and array[i]
                    array[i - 1], array[i] = array[i], array[i - 1]
                    swapped = True
            n -= 1

class QuickSortStrategy(SortStrategy):
    def sort(self, array: List[int]) -> None:
        print("Sorting using Quick Sort")
        self._quick_sort(array, 0, len(array) - 1)

    def _quick_sort(self, array: List[int], low: int, high: int) -> None:
        if low < high:
            partition_index = self._partition(array, low, high)
            self._quick_sort(array, low, partition_index - 1)
            self._quick_sort(array, partition_index + 1, high)

    def _partition(self, array: List[int], low: int, high: int) -> int:
        pivot = array[high]
        i = low - 1
        for j in range(low, high):
            if array[j] <= pivot:
                i += 1
                # Swap array[i] and array[j]
                array[i], array[j] = array[j], array[i]
        # Swap array[i+1] and array[high] (or pivot)
        array[i + 1], array[high] = array[high], array[i + 1]
        return i + 1

# Kontext
class SortContext:
    def __init__(self) -> None:
        self.strategy = None

    def set_strategy(self, strategy: SortStrategy) -> None:
        self.strategy = strategy

    def perform_sort(self, array: List[int]) -> None:
        self.strategy.sort(array)
        # Print the sorted array
        print(array)

# Client-Code
if __name__ == "__main__":
    array_to_sort = [5, 2, 9, 1, 5, 6]

    sort_context = SortContext()

    # Verwende Bubble Sort
    sort_context.set_strategy(BubbleSortStrategy())
    sort_context.perform_sort(array_to_sort.copy())

    # Verwende Quick Sort
    sort_context.set_strategy(QuickSortStrategy())
    sort_context.perform_sort(array_to_sort.copy())
