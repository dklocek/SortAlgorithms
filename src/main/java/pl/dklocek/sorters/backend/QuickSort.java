package pl.dklocek.sorters.backend;


import java.util.ArrayList;
import java.util.List;

public class QuickSort{



    public static List<int[]> sort(int[] numbers, boolean allSteps) {
        List sorted = new ArrayList<>();

        if (numbers.length < 2){
               sorted.add(numbers);
            return sorted;
        };

        sorted = sorting(sorted,allSteps,numbers,0, numbers.length - 1);
        sorted.add(numbers.clone());
        return sorted;
    }

    public static List sorting(List sorted, boolean allSteps,int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int j = start;
        int temp;

        if (j < end) {
           for (int i = j; i < end; i++) {

                if (numbers[i] <= pivot) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    j++;
                    if(allSteps)sorted.add(numbers.clone());
                 }

            }

            temp = numbers[j];
            numbers[j] = pivot;
            numbers[end] = temp;

            if(j>start)
            sorting(sorted,allSteps,numbers,start, j - 1);
            sorting(sorted,allSteps,numbers,j + 1, end);

        }

     return sorted;


    }
}
