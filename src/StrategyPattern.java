import java.util.*;

// Strategy Interface
interface Sort {
    void sortNow(List<Integer> arr);
}

// Concrete Strategy - BubbleSort
class BubbleSort implements Sort {
    @Override
    public void sortNow(List<Integer> arr) {
        Collections.sort(arr); // Using built-in sort for demo
        System.out.println("Sorted using Bubble Sort:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

// Concrete Strategy - MergeSort
class MergeSort implements Sort {
    @Override
    public void sortNow(List<Integer> arr) {
        Collections.sort(arr); // Using built-in sort for demo
        System.out.println("Sorted using Merge Sort:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

// Context
class SortingAlgoContext {
    private Sort sortingAlgo;

    public SortingAlgoContext(Sort algo) {
        this.sortingAlgo = algo;
    }

    public void setSortingAlgoInContext(Sort algo) {
        this.sortingAlgo = algo;
    }

    public void performSortAlgo(List<Integer> arr) {
        sortingAlgo.sortNow(arr);
    }
}

// Client
public class StrategyPattern {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(9, 3, 5, 7));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 3, 4, 6, 3, 21, 4, 5));

        SortingAlgoContext context = new SortingAlgoContext(new BubbleSort());
        context.performSortAlgo(arr1);

        context.setSortingAlgoInContext(new MergeSort());
        context.performSortAlgo(arr2);
    }
}
