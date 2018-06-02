package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    private static List<int[]> sorted;
    private static boolean allSteps;
    private static int[] numbers;

    public static List<int[]> sort(int[] numbers, boolean allSetps) {
        sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        allSteps = allSetps;
        HeapSort.numbers = numbers;
        heapSort(numbers.length);

        if (!allSetps) sorted.add(numbers);
        return sorted;
    }

    private static void heapSort(int end) {

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;


        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if ((end - 1 % 2) == 0) {
                rightChild = lastParent * 2 + 2;

                if (numbers[rightChild] > numbers[leftChild] && numbers[rightChild] > numbers[lastParent]) {
                    Swap.swap(numbers, rightChild, lastParent);
                    if (allSteps) sorted.add(numbers);
                }
                if (numbers[leftChild] > numbers[rightChild] && numbers[leftChild] > numbers[lastParent]) {
                    Swap.swap(numbers, leftChild, lastParent);
                    if (allSteps) sorted.add(numbers);
                }
            } else {


                if (numbers[leftChild] > numbers[lastParent]) {
                    Swap.swap(numbers, leftChild, lastParent);
                    if (allSteps) sorted.add(numbers);
                }
            }

            lastParent -= 1;
        }

        Swap.swap(numbers, 0, end - 1);
        if (allSteps) sorted.add(numbers);
        if (end > 1)
            heapSort(end - 1);

    }

}
