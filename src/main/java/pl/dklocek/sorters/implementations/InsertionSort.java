package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;
import pl.dklocek.sorters.others.Student;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements Sorter {

    @Override
    public  List<Integer[]> sort(Integer[] numbers, Boolean allSteps) {

        List<Integer[]> sorted = new ArrayList<>();

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

    @Override
    public  List<String[]> sort(String[] table, Boolean allSteps) {

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

            while (index > 0 && ((table[index - 1].compareToIgnoreCase(inserted) > 0) ||
                                (table[index - 1].compareToIgnoreCase(inserted)==0 && table[index-1].compareTo(inserted)>0))) {
                table[index] = table[index - 1];
                index--;
            }
            table[index] = inserted;

            if (allSteps) sorted.add(table.clone());

        }

        if (!allSteps) sorted.add(table);

        return sorted;
    }

    @Override
    public  List<Student[]> sort(Student[] students, Boolean allSteps, String compareBy) {

        List<Student[]> sorted = new ArrayList<>();

        if (students.length < 2) {
            sorted.add(students.clone());
            return sorted;
        }

        int index;
        Student inserted;

        for (int i = 1; i < students.length; i++) {

            index = i;
            inserted = students[i];

            while (index > 0 && students[index - 1].compareBy(inserted,compareBy) > 0) {
                students[index] = students[index - 1];
                index--;
            }
            students[index] = inserted;

            if (allSteps) sorted.add(students.clone());

        }

        if (!allSteps) sorted.add(students.clone());

        return sorted;
    }


}
