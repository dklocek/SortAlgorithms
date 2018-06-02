package pl.dklocek.sorters.implementations;


public class Swap {

    public static void swap(int[] numbers, int a, int b) {
        int temp;
        temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
