package pl.dklocek.sorters.others;


import pl.dklocek.sorters.implementations.BubbleSort;
import pl.dklocek.sorters.implementations.InsertionSort;
import pl.dklocek.sorters.implementations.QuickSort;
import pl.dklocek.sorters.implementations.SelectionSort;

import java.util.HashMap;
import java.util.Map;

public class CompareSorters {
   private static Map<String,Double> comparationData = new HashMap<>();
   private static Long start;
   private static Double elapsed;
   private static int[] result;
    public static Map compare(int[] numbers){


        start = System.nanoTime();
        result = BubbleSort.sort(numbers,false).get(0);
        elapsed = (System.nanoTime()-start)/1000000.00;
        comparationData.put("BubbleSort",elapsed);

        start = System.nanoTime();
        result = InsertionSort.sort(numbers,false).get(0);
        elapsed = (System.nanoTime()-start)/1000000.00;
        comparationData.put("InsertionSort",elapsed);

        start = System.nanoTime();
        result = QuickSort.sort(numbers,false).get(0);
        elapsed = (System.nanoTime()-start)/1000000.00;
        comparationData.put("QuickSort",elapsed);

        start = System.nanoTime();
        result = SelectionSort.sort(numbers,false).get(0);
        elapsed = (System.nanoTime()-start)/1000000.00;
        comparationData.put("SelectionSort",elapsed);




        return comparationData;
    }

}
