package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {


    public static List<int[]> sort(int[] numbers, boolean allSteps) {
        List sorted = new ArrayList<>();
        int temp;
        boolean swapMade = false;

        if(numbers.length<2){
               sorted.add(numbers);
            return sorted;
        };


        do {
            swapMade=false;

            for(int i=0 ; i<numbers.length-1; i++){
                if(numbers[i]>numbers[i+1]){
                    temp = numbers[i+1];
                    numbers[i+1]=numbers[i];
                    numbers[i]=temp;
                    swapMade=true;
                    if(allSteps)sorted.add(numbers.clone());
                }
            }
        } while (swapMade);

        if(!allSteps)sorted.add(numbers);
        return sorted;
    }
}
