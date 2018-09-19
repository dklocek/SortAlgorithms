package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;
import pl.dklocek.sorters.others.Student;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements Sorter{

    @Override
    public List<Integer[]> sort(Integer[] numbers, Boolean allSteps) {

        List<Integer[]> sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers.clone());
            return sorted;
        }

        int min, temp;
        Integer[] foundMinAndIndex;

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

    private static Integer[] findMin(Integer[] array, Integer arrayIndex) {

        Integer min = array[arrayIndex];
        Integer index = arrayIndex;

        for (int i = arrayIndex + 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }

        return new Integer[]{min, index};
    }

    @Override
    public List<String[]> sort(String[] table, Boolean allSteps) {

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


    @Override
    public List<Student[]> sort(Student[] data, Boolean allSteps, String sortBy) {

        List<Student[]> sorted = new ArrayList<>();
        Student[] students = new Student[]{};
        students[0]= new Student("Adam", "Jan",1,2);
        sorted.add(students);
        return sorted;
    }
}
