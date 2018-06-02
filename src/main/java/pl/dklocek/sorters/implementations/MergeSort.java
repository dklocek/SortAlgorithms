package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private static List<int[]> sorted;
    private static int[] temp;
    private static int[] numbers;
    private static boolean allSteps;

    public static List<int[]> sort(int[] numbers, boolean allSteps) {

        sorted = new ArrayList<>();
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


        for (int i = start; i <= end; i++) temp[i] = numbers[i];

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


}
