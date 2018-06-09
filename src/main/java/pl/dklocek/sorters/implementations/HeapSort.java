package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.others.Student;

import java.util.ArrayList;
import java.util.List;

import static pl.dklocek.sorters.implementations.Swap.swap;

public class HeapSort {

    public static List<int[]> sort(int[] numbers, boolean allSteps, int end) {
        List<int[]> sorted = new ArrayList<>();

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;

        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if (leftChild + 1 < end) {
                rightChild = lastParent * 2 + 2;

                if (numbers[rightChild] > numbers[leftChild] && numbers[rightChild] > numbers[lastParent]) {
                    swap(numbers, rightChild, lastParent);
                    if (allSteps) sorted.add(numbers);
                }
                if (numbers[leftChild] > numbers[rightChild] && numbers[leftChild] > numbers[lastParent]) {
                    swap(numbers, leftChild, lastParent);
                    if (allSteps) sorted.add(numbers);
                }
            } else {


                if (numbers[leftChild] > numbers[lastParent]) {
                    swap(numbers, leftChild, lastParent);
                    if (allSteps) sorted.add(numbers);
                }
            }

            lastParent -= 1;
        }

        swap(numbers, 0, end - 1);
        if (allSteps) sorted.add(numbers);
        if (end > 1)
            sort(numbers,allSteps,end - 1);

        if (!allSteps) sorted.add(numbers);
        return sorted;
    }

    public static List<String[]> sort(String[] table, boolean allSteps, int end) {
        List<String[]> sortedString = new ArrayList<>();

        if (table.length < 2) {
            sortedString.add(table);
            return sortedString;
        }

        int lastParent = end / 2 - 1;
        int leftChildIndex;
        int rightChildIndex;
        int parentIndex = lastParent;

        String rightChild;
        String leftChild;
        String parent;

        while (parentIndex > -1) {
            leftChildIndex = parentIndex * 2 + 1;
            leftChild = table[leftChildIndex];
            parent = table[parentIndex];

            if (leftChildIndex + 1 < end) {

                rightChildIndex = parentIndex * 2 + 2;
                rightChild = table[rightChildIndex];

                if (leftChild.compareToIgnoreCase(rightChild) > 0 || leftChild.compareToIgnoreCase(rightChild) == 0 && leftChild.compareTo(rightChild) > 0) {
                    if (leftChild.compareToIgnoreCase(parent) > 0 || leftChild.compareToIgnoreCase(parent) == 0 && leftChild.compareTo(parent) > 0) {
                        swap(table, leftChildIndex, parentIndex);
                        if (allSteps) sortedString.add(table);
                    }
                } else {
                    if (rightChild.compareToIgnoreCase(parent) > 0 || rightChild.compareToIgnoreCase(parent) == 0 && rightChild.compareTo(parent) > 0) {
                        swap(table, rightChildIndex, parentIndex);
                        if (allSteps) sortedString.add(table);
                    }
                }


            } else {

                leftChild = table[leftChildIndex];
                parent = table[parentIndex];

                if (leftChild.compareToIgnoreCase(parent) > 0 || leftChild.compareToIgnoreCase(parent) == 0 && leftChild.compareTo(parent) > 0) {
                    swap(table, leftChildIndex, parentIndex);
                    if (allSteps) sortedString.add(table);
                }
            }

            parentIndex -= 1;
        }

        swap(table, 0, end - 1);
        if (allSteps) sortedString.add(table);
        if (end > 1)
            sort(table,allSteps,end - 1);

        if (!allSteps) sortedString.add(table);
        return sortedString;
    }

    public static List<Student[]> sortByName(Student[] students, boolean allSteps, int end) {
        List<Student[]> sorted = new ArrayList<>();

        if (students.length < 2) {
            sorted.add(students);
            return sorted;
        }

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;

        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if (leftChild + 1 < end) {
                rightChild = lastParent * 2 + 2;

                if (students[rightChild].compareByName(students[leftChild]) > 0 && students[rightChild].compareByName(students[lastParent]) > 0) {
                    swap(students, rightChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
                if (students[leftChild].compareByName(students[rightChild]) > 0 && students[leftChild].compareByName(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            } else {


                if (students[leftChild].compareByName(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            }

            lastParent -= 1;
        }

        swap(students, 0, end - 1);
        if (allSteps) sorted.add(students);
        if (end > 1)
            sortByName(students,allSteps,end - 1);

        if (!allSteps) sorted.add(students);
        return sorted;
    }

    public static List<Student[]> sortBySurname(Student[] students, boolean allSteps, int end) {
        List<Student[]> sorted = new ArrayList<>();

        if (students.length < 2) {
            sorted.add(students);
            return sorted;
        }

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;

        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if (leftChild + 1 < end) {
                rightChild = lastParent * 2 + 2;

                if (students[rightChild].compareBySurname(students[leftChild]) > 0 && students[rightChild].compareBySurname(students[lastParent]) > 0) {
                    swap(students, rightChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
                if (students[leftChild].compareBySurname(students[rightChild]) > 0 && students[leftChild].compareBySurname(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            } else {


                if (students[leftChild].compareBySurname(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            }

            lastParent -= 1;
        }

        swap(students, 0, end - 1);
        if (allSteps) sorted.add(students);
        if (end > 1)
            sortBySurname(students,allSteps,end - 1);

        if (!allSteps) sorted.add(students);
        return sorted;
    }

    public static List<Student[]> sortById(Student[] students, boolean allSteps, int end) {
        List<Student[]> sorted = new ArrayList<>();

        if (students.length < 2) {
            sorted.add(students);
            return sorted;
        }

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;

        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if (leftChild + 1 < end) {
                rightChild = lastParent * 2 + 2;

                if (students[rightChild].compareById(students[leftChild]) > 0 && students[rightChild].compareById(students[lastParent]) > 0) {
                    swap(students, rightChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
                if (students[leftChild].compareById(students[rightChild]) > 0 && students[leftChild].compareById(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            } else {


                if (students[leftChild].compareById(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            }

            lastParent -= 1;
        }

        swap(students, 0, end - 1);
        if (allSteps) sorted.add(students);
        if (end > 1)
            sortById(students,allSteps,end - 1);

        if (!allSteps) sorted.add(students);
        return sorted;
    }

    public static List<Student[]> sortByAge(Student[] students, boolean allSteps, int end) {
        List<Student[]> sorted = new ArrayList<>();

        if (students.length < 2) {
            sorted.add(students);
            return sorted;
        }

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;

        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if (leftChild + 1 < end) {
                rightChild = lastParent * 2 + 2;

                if (students[rightChild].compareByAge(students[leftChild]) > 0 && students[rightChild].compareByAge(students[lastParent]) > 0) {
                    swap(students, rightChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
                if (students[leftChild].compareByAge(students[rightChild]) > 0 && students[leftChild].compareByAge(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            } else {


                if (students[leftChild].compareByAge(students[lastParent]) > 0) {
                    swap(students, leftChild, lastParent);
                    if (allSteps) sorted.add(students);
                }
            }

            lastParent -= 1;
        }

        swap(students, 0, end - 1);
        if (allSteps) sorted.add(students);
        if (end > 1)
            sortByAge(students,allSteps,end - 1);

        if (!allSteps) sorted.add(students);
        return sorted;
    }
}
