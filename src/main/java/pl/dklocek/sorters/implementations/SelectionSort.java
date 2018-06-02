package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    private static List sorted;

    public static List<int[]> sort(int[] numbers, boolean allSteps) {

        sorted = new ArrayList<>();

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
}
