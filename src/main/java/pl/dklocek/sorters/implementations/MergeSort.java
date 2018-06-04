package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    /*---------- INT ---  INT ---- INT -----------*/
    private static List<int[]> sorted;
    private static int[] temp;
    private static int[] numbers;
    private static boolean allSteps;

    public static List<int[]> sort(int[] numbers, boolean allSteps) {
        sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        temp = new int[numbers.length];
        MergeSort.numbers = numbers;
        MergeSort.allSteps = allSteps;

        mergeSort(0, numbers.length - 1);

        if (!allSteps) sorted.add(numbers);

        return sorted;
    }

    static void mergeSort(int start, int end) {

        int middle;

        if (start < end) {
            middle = (end + start) / 2;
            mergeSort(start, middle);
            mergeSort(middle + 1, end);
            merge(start, middle, end);

        }
    }

    static void merge(int start, int middle, int end) {

        temp = numbers.clone();

        int i = start;
        int j = middle + 1;
        int x = start;

        while (i <= middle && j <= end) {
            if (temp[i] < temp[j])
                numbers[x++] = temp[i++];
            else
                numbers[x++] = temp[j++];
        }

        while (i <= middle) numbers[x++] = temp[i++];
        while (j <= end) numbers[x++] = temp[j++];

        if (allSteps) sorted.add(numbers.clone());
    }
    /*---------STRING --------- STRING --------STRING---------*/
    private static List<String[]> sortedString;
    private static String[] tempString;
    private static String[] table;

    public static List<String[]> sort(String[] table, boolean allSteps) {
        sortedString = new ArrayList<>();

        if (table.length < 2) {
            sortedString.add(table);
            return sortedString;
        }

        tempString = new String[table.length];
        MergeSort.table = table;
        MergeSort.allSteps = allSteps;

        mergeSortString(0, table.length - 1);

        if (!allSteps) sortedString.add(table);

        return sortedString;
    }

    static void mergeSortString(int start, int end) {

        int middle;

        if (start < end) {
            middle = (end + start) / 2;
            mergeSortString(start, middle);
            mergeSortString(middle + 1, end);
            mergeString(start, middle, end);

        }
    }

    static void mergeString(int start, int middle, int end) {

        tempString = table.clone();

        int i = start;
        int j = middle + 1;
        int x = start;

        while (i <= middle && j <= end) {
            if (tempString[i].compareToIgnoreCase(tempString[j]) < 0 || tempString[i].compareToIgnoreCase(tempString[j]) ==0 && tempString[i].compareTo(tempString[j])<0)
                table[x++] = tempString[i++];
            else
                table[x++] = tempString[j++];
        }

        while (i <= middle) table[x++] = tempString[i++];
        while (j <= end) table[x++] = tempString[j++];

        if (allSteps) sortedString.add(table.clone());
    }


}

