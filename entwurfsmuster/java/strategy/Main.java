public class Main {
    public static void main(String[] args) {
        int[] arrayToSort = {5, 2, 9, 1, 5, 6};

        SortContext sortContext = new SortContext();

        // Verwende Bubble Sort
        sortContext.setStrategy(new BubbleSortStrategy());
        sortContext.performSort(arrayToSort.clone());

        // Verwende Quick Sort
        sortContext.setStrategy(new QuickSortStrategy());
        sortContext.performSort(arrayToSort.clone());
    }
}