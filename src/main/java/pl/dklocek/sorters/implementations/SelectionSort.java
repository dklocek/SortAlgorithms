package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static List<int[]> sort(int[] numbers, boolean allSteps) {

        List<int[]> sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        int min, temp;
        int[] foundMinAndIndex;

        for (int i = 0; i < numbers.length; i++) {

            foundMinAndIndex = findMin(numbers, i);
            min = foundMinAndIndex[0];
            temp = numbers[i];
            numbers[i] = min;
            numbers[foundMinAndIndex[1]] = temp;

            if (allSteps || i == numbers.length - 1)
                sorted.add(numbers.clone());
        }

        return sorted;
    }

    private static int[] findMin(int[] array, int arrayIndex) {

        int min = array[arrayIndex];
        int index = arrayIndex;

        for (int i = arrayIndex + 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }

        return new int[]{min, index};
    }

    public static List<String[]> sort(String[] table, boolean allSteps) {

        List<String[]> sorted = new ArrayList<>();

        if (table.length < 2) {
            sorted.add(table);
            return sorted;
        }

        String min, temp;
        String[] foundMinAndIndex;

        for (int i = 0; i < table.length; i++) {

            foundMinAndIndex = findMinString(table, i);
            min = foundMinAndIndex[0];
            temp = table[i];
            table[i] = min;
            table[Integer.valueOf(foundMinAndIndex[1])] = temp;

            if (allSteps || i == table.length - 1)
                sorted.add(table.clone());
        }

        return sorted;
    }

    private static String[] findMinString(String[] array, int arrayIndex) {

        String min = array[arrayIndex];
        int index = arrayIndex;

        for (int i = arrayIndex + 1; i < array.length; i++) {
            if (array[i].compareToIgnoreCase(min) < 0 || array[i].compareToIgnoreCase(min)==0 && array[i].compareTo(min) < 0) {
                min = array[i];
                index = i;
            }
        }

        return new String[]{min, ""+index};
    }
}
