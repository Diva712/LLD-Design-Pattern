
/**
 * InnerMain
 */
interface SortingStrategy {

  void sort(int arr[]);

}

class BubbleSort implements SortingStrategy {
  public void sort(int arr[]) {
    System.out.println("Sorting using Bubble Sort Algorithms ");
  }
}

class QuickSort implements SortingStrategy {
  public void sort(int arr[]) {
    System.out.println("sorting using Quick Sort");
  }
}

class MergeSort implements SortingStrategy {
  public void sort(int arr[]) {
    System.out.println("sorting using Merge Sort");
  }
}

class SortingContext {
  SortingStrategy sortingStrategy;

  SortingContext(SortingStrategy sortingStrategy) {
    this.sortingStrategy = sortingStrategy;
  }

  void sort(int arr[]) {
    sortingStrategy.sort(arr);
  }
}

public class Main {
  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    SortingContext sortingContext = new SortingContext(new BubbleSort());
    sortingContext.sort(arr);
  }
}
