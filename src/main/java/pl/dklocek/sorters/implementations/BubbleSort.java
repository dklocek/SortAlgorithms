package pl.dklocek.sorters.implementations;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static List<int[]> sort(int[] numbers, boolean allSteps) {

        List<int[]> sorted = new ArrayList<>();
        boolean swapMade;

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        do {
            swapMade = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    Swap.swap(numbers, i, i + 1);
                    swapMade = true;
                    if (allSteps) sorted.add(numbers.clone());
                }
            }
        } while (swapMade);

        if (!allSteps) sorted.add(numbers);
        return sorted;
    }

    public static List<String[]> sort(String[] table, boolean allSteps){
        List<String[]> sorted = new ArrayList<>();
        boolean swapMade;

        if(table.length<2){
            sorted.add(table);
            return sorted;
        }

        do {
           swapMade=false;

            for(int i = 0 ; i< table.length -1; i++){
                if(table[i].compareTo(table[i+1]) > 0) {
                   Swap.swap(table,i,i+1);
                   swapMade = true;
                    if(allSteps)sorted.add(table);
                }
            }

        } while (swapMade);

        if(!allSteps)sorted.add(table);

        return sorted;
    }
}
