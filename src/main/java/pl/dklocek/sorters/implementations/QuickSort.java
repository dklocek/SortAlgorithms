package pl.dklocek.sorters.implementations;


import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private static List<int[]> sorted;

    public static List<int[]> sort(int[] numbers, boolean allSteps) {
        QuickSort.sorted = new ArrayList<>();

        if (numbers.length < 2){
               sorted.add(numbers);
            return sorted;
        }

        sorted = sorting(allSteps,numbers,0, numbers.length - 1);
        sorted.add(numbers.clone());
        return sorted;
    }

    public static List<int[]> sorting(boolean allSteps,int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int j = start;
        int temp;

        if (j < end) {
           for (int i = j; i < end; i++) {

                if (numbers[i] <= pivot) {
                    Swap.swap(numbers,i,j);
                    j++;
                    if(allSteps)sorted.add(numbers.clone());
                 }

            }

            temp = numbers[j];
            numbers[j] = pivot;
            numbers[end] = temp;

            if(((j-1)-start)<end-(j+1)){
            if(j>start)
            sorting(allSteps,numbers,start, j - 1);}
            else
            sorting(allSteps,numbers,j + 1, end);

        }

     return sorted;


    }
}
