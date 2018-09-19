package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;
import pl.dklocek.sorters.others.Student;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorter {
    /*---------- INT ---  INT ---- INT -----------*/
    private static List<Integer[]> sorted;
    private static Integer[] temp;
    private static Integer[] numbers;
    private static boolean allSteps;

    @Override
    public List<Integer[]> sort(Integer[] numbers, Boolean allSteps) {
        sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers.clone());
            return sorted;
        }

        temp = new Integer[numbers.length];
        MergeSort.numbers = numbers;
        MergeSort.allSteps = allSteps;

        mergeSort(0, numbers.length - 1);

        if (!allSteps) sorted.add(numbers.clone());

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

    @Override
    public List<String[]> sort(String[] table, Boolean allSteps) {
        sortedString = new ArrayList<>();

        if (table.length < 2) {
            sortedString.add(table.clone());
            return sortedString;
        }

        tempString = new String[table.length];
        MergeSort.table = table;
        MergeSort.allSteps = allSteps;

        mergeSortString(0, table.length - 1);

        if (!allSteps) sortedString.add(table.clone());

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
            if (tempString[i].compareToIgnoreCase(tempString[j]) < 0 || tempString[i].compareToIgnoreCase(tempString[j]) == 0 && tempString[i].compareTo(tempString[j]) < 0)
                table[x++] = tempString[i++];
            else
                table[x++] = tempString[j++];
        }

        while (i <= middle) table[x++] = tempString[i++];
        while (j <= end) table[x++] = tempString[j++];

        if (allSteps) sortedString.add(table.clone());
    }

    private static List<Student[]> sortedStudents;
    private static Student[] tempStudents;
    private static Student[] students;
    private static String compareBy;

    @Override
    public  List<Student[]> sort(Student[] students, Boolean allSteps, String compareBy) {
        sortedStudents = new ArrayList<>();
        MergeSort.compareBy = compareBy;
        if (students.length < 2) {
            sortedStudents.add(students.clone());
            return sortedStudents;
        }

        tempStudents = new Student[students.length];
        MergeSort.students = students;
        MergeSort.allSteps = allSteps;

        mergeSortStudents(0, students.length - 1);

        if (!allSteps) sortedStudents.add(students.clone());

        return sortedStudents;
    }

    static void mergeSortStudents(int start, int end) {

        int middle;

        if (start < end) {
            middle = (end + start) / 2;
            mergeSortStudents(start, middle);
            mergeSortStudents(middle + 1, end);
            mergeStudents(start, middle, end);

        }
    }

    static void mergeStudents(int start, int middle, int end) {

        tempStudents = students.clone();

        int i = start;
        int j = middle + 1;
        int x = start;

        while (i <= middle && j <= end) {
            if (tempStudents[i].compareBy(tempStudents[j], compareBy) < 0)
                students[x++] = tempStudents[i++];
            else
                students[x++] = tempStudents[j++];
        }

        while (i <= middle) students[x++] = tempStudents[i++];
        while (j <= end) students[x++] = tempStudents[j++];

        if (allSteps) sortedStudents.add(students.clone());
    }
}


