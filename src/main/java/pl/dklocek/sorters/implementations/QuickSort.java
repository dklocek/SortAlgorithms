package pl.dklocek.sorters.implementations;


import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private static List<int[]> sorted;

    public static List<int[]> sort(int[] numbers, boolean allSteps) {
        sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        sorted = sorting(allSteps, numbers, 0, numbers.length - 1);
        sorted.add(numbers.clone());
        return sorted;
    }

    public static List<int[]> sorting(boolean allSteps, int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int j = start;
        int temp;

        if (j < end) {
            for (int i = j; i < end; i++) {

                if (numbers[i] <= pivot) {
                    Swap.swap(numbers, i, j);
                    j++;
                    if (allSteps) sorted.add(numbers.clone());
                }

            }

            temp = numbers[j];
            numbers[j] = pivot;
            numbers[end] = temp;

            if (((j - 1) - start) < end - (j + 1)) {
                if (j > start)
                    sorting(allSteps, numbers, start, j - 1);
                sorting(allSteps, numbers, j + 1, end);
            } else
                sorting(allSteps, numbers, j + 1, end);
            sorting(allSteps, numbers, start, j - 1);
        }

        return sorted;
    }

    private static List<String[]> sortedString;

    public static List<String[]> sort(String[] table, boolean allSteps) {
        sortedString = new ArrayList<>();

        if (table.length < 2) {
            sortedString.add(table);
            return sortedString;
        }

        sortedString = sortingString(allSteps, table, 0, table.length - 1);
        sortedString.add(table.clone());
        return sortedString;
    }

    public static List<String[]> sortingString(boolean allSteps, String[] table, int start, int end) {
        String pivot = table[end];
        int j = start;
        String temp;

        if (j < end) {
            for (int i = j; i < end; i++) {

                if (table[i].compareToIgnoreCase(pivot) <= 0) {
                    Swap.swap(table, i, j);
                    j++;
                    if (allSteps) sortedString.add(table.clone());
                }
            }

            temp = table[j];
            table[j] = pivot;
            table[end] = temp;

            if (((j - 1) - start) < end - (j + 1)) {
                if (j > start)
                    sortingString(allSteps, table, start, j - 1);
                sortingString(allSteps, table, j + 1, end);
            } else
                sortingString(allSteps, table, j + 1, end);
            sortingString(allSteps, table, start, j - 1);
        }

        return sortedString;
    }

}
