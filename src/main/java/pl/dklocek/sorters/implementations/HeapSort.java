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
            if (leftChild+1<end) {
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

    private static List<String[]> sortedString;
    private static String[] table;


    public static List<String[]> sort(String[] table, boolean allSteps) {
        sortedString = new ArrayList<>();

        if (table.length < 2) {
            sortedString.add(table);
            return sortedString;
        }

        HeapSort.allSteps = allSteps;
        HeapSort.table = table;
        heapSortString(table.length);

        if (!allSteps) sortedString.add(table);
        return sortedString;
    }

    private static void heapSortString(int end) {

        int lastParent = end / 2 - 1;
        int leftChildIndex;
        int rightChildIndex;
        int parentIndex = lastParent;

        String rightChild ;
        String leftChild ;
        String parent ;

        while (parentIndex > -1) {
            leftChildIndex = parentIndex * 2 + 1;

            if (leftChildIndex+1<end) {

                rightChildIndex = parentIndex * 2 + 2;

                rightChild = table[rightChildIndex];
                leftChild = table[leftChildIndex];
                parent = table[parentIndex];

                if (rightChild.compareToIgnoreCase(leftChild) > 0 && rightChild.compareToIgnoreCase(parent) > 0) {

                    Swap.swap(table, rightChildIndex, parentIndex);
                    if (allSteps) sortedString.add(table);
                }
                if (table[leftChildIndex].compareToIgnoreCase(table[rightChildIndex]) > 0 &&
                        table[leftChildIndex].compareToIgnoreCase(table[parentIndex]) > 0) {

                    Swap.swap(table, leftChildIndex, parentIndex);
                    if (allSteps) sortedString.add(table);
                }
              //---------------------------------------------------------------------------------------------------//
                if (rightChild.compareToIgnoreCase(leftChild) > 0 && rightChild.compareToIgnoreCase(parent) > 0) {

                    Swap.swap(table, rightChildIndex, parentIndex);
                    if (allSteps) sortedString.add(table);
                }
                if (table[leftChildIndex].compareToIgnoreCase(table[rightChildIndex]) > 0 &&
                        table[leftChildIndex].compareToIgnoreCase(table[parentIndex]) > 0) {

                    Swap.swap(table, leftChildIndex, parentIndex);
                    if (allSteps) sortedString.add(table);
                }


            } else {


                if (table[leftChildIndex].compareToIgnoreCase(table[parentIndex]) > 0) {
                    Swap.swap(table, leftChildIndex, parentIndex);
                    if (allSteps) sortedString.add(table);
                }
            }

            parentIndex -= 1;
        }

        Swap.swap(table, 0, end - 1);
        if (allSteps) sortedString.add(table);
        if (end > 1)
            heapSortString(end - 1);

    }

}
