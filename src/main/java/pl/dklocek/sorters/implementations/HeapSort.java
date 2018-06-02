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
        int leftChild;
        int rightChild;
        int parent = lastParent;


        while (parent > -1) {
            leftChild = parent * 2 + 1;
            if (leftChild+1<end) {
                rightChild = parent * 2 + 2;

                if (table[rightChild].compareTo(table[leftChild]) > 0 && table[rightChild].compareTo(table[parent])>0) {
                    Swap.swap(table, rightChild, parent);
                    if (allSteps) sortedString.add(table);
                }
                if (table[leftChild].compareTo(table[rightChild]) > 0 && table[leftChild].compareTo(table[parent]) > 0) {
                    Swap.swap(table, leftChild, parent);
                    if (allSteps) sortedString.add(table);
                }
            } else {


                if (table[leftChild].compareTo(table[parent]) > 0) {
                    Swap.swap(table, leftChild, parent);
                    if (allSteps) sortedString.add(table);
                }
            }

            parent -= 1;
        }

        Swap.swap(table, 0, end - 1);
        if (allSteps) sortedString.add(table);
        if (end > 1)
            heapSortString(end - 1);

    }

}
