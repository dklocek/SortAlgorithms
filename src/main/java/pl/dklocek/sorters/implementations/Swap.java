package pl.dklocek.sorters.implementations;


import pl.dklocek.sorters.others.Student;

public class Swap {

    public static void swap(Integer[] numbers, int a, int b) {
        int temp;
        temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void swap(String[] numbers, int a, int b) {
        String temp;
        temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void swap(Student[] students, int a, int b){
        Student temp;
        temp = students[a];
        students[a]=students[b];
        students[b]=temp;
    }
}
