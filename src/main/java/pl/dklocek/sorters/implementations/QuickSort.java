package pl.dklocek.sorters.implementations;


import pl.dklocek.sorters.interfaces.Sorter;
import pl.dklocek.sorters.others.Student;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Sorter {

    private static List<Integer[]> sorted;

    @Override
    public List<Integer[]> sort(Integer[] numbers, Boolean allSteps) {
        sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers.clone());
            return sorted;
        }

        sorted = sorting(allSteps, numbers, 0, numbers.length - 1);
        sorted.add(numbers.clone());
        return sorted;
    }

    public static List<Integer[]> sorting(boolean allSteps, Integer[] numbers, int start, int end) {
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
    @Override
    public List<String[]> sort(String[] table, Boolean allSteps) {
        sortedString = new ArrayList<>();

        if (table.length < 2) {
            sortedString.add(table.clone());
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

    private static List<Student[]> sortedStudents;
    private static String compareBy;

    @Override
    public List<Student[]> sort(Student[] students, Boolean allSteps, String compareBy) {
        sortedStudents = new ArrayList<>();
        QuickSort.compareBy=compareBy;
        if (students.length < 2) {
            sortedStudents.add(students);
            return sortedStudents;
        }

        sortingStudents(allSteps, students, 0, students.length - 1);
        sortedStudents.add(students.clone());
        return sortedStudents;
    }
    public static void sortingStudents(boolean allSteps, Student[] students, int start, int end) {
        Student pivot = students[end];
        int j = start;
        Student temp;

        if (j < end) {
            for (int i = j; i < end; i++) {

                if (students[i].compareBy(pivot,compareBy) <= 0) {
                    Swap.swap(students, i, j);
                    j++;
                    if (allSteps) sortedStudents.add(students.clone());
                }

            }

            temp = students[j];
            students[j] = pivot;
            students[end] = temp;

            if (((j - 1) - start) < end - (j + 1)) {
                if (j > start) {
                    sortingStudents(allSteps, students, start, j - 1);
                    sortingStudents(allSteps, students, j + 1, end);
                }
            } else {
                sortingStudents(allSteps, students, j + 1, end);
                sortingStudents(allSteps, students, start, j - 1);
            }
        }

    }

}
