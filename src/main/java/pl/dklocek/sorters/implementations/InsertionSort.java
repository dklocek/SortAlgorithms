package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static List<int[]> sort(int[] numbers, boolean allSteps) {

        List<int[]> sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        int sortedIndex, insertedVariable;

        for (int i = 1; i < numbers.length; i++) {

            sortedIndex = i;
            insertedVariable = numbers[i];

            while (sortedIndex > 0 && numbers[sortedIndex - 1] > insertedVariable) {
                numbers[sortedIndex] = numbers[sortedIndex - 1];
                sortedIndex--;
            }
            numbers[sortedIndex] = insertedVariable;

            if (allSteps) sorted.add(numbers.clone());

        }

        if (!allSteps) sorted.add(numbers);

        return sorted;
    }
}
