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

    public static List<String[]> sort(String[] table, boolean allSteps) {

        List<String[]> sorted = new ArrayList<>();

        if (table.length < 2) {
            sorted.add(table);
            return sorted;
        }

        int index;
        String inserted;

        for (int i = 1; i < table.length; i++) {

            index = i;
            inserted = table[i];

            while (index > 0 && table[index - 1].compareTo(inserted) > 0) {
                table[index] = table[index - 1];
                index--;
            }
            table[index] = inserted;

            if (allSteps) sorted.add(table.clone());

        }

        if (!allSteps) sorted.add(table);

        return sorted;
    }
}
