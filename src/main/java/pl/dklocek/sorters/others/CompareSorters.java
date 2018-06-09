package pl.dklocek.sorters.others;


import pl.dklocek.sorters.implementations.*;

import java.util.*;

public class CompareSorters {

    private static Map<String, Double> comparatorData = new HashMap<>();


    public static Map compare(int[] numbers) {

        Long start;
        Double elapsed;

        start = System.nanoTime();
        BubbleSort.sort(numbers, false).get(0);
        elapsed = (System.nanoTime() - start) / 1000000.00;
        comparatorData.put("BubbleSort", elapsed);

        start = System.nanoTime();
        InsertionSort.sort(numbers, false).get(0);
        elapsed = (System.nanoTime() - start) / 1000000.00;
        comparatorData.put("InsertionSort", elapsed);

        start = System.nanoTime();
        QuickSort.sort(numbers, false).get(0);
        elapsed = (System.nanoTime() - start) / 1000000.00;
        comparatorData.put("QuickSort", elapsed);

        start = System.nanoTime();
        SelectionSort.sort(numbers, false).get(0);
        elapsed = (System.nanoTime() - start) / 1000000.00;
        comparatorData.put("SelectionSort", elapsed);

        start = System.nanoTime();
        MergeSort.sort(numbers, false).get(0);
        elapsed = (System.nanoTime() - start) / 1000000.00;
        comparatorData.put("MergeSort", elapsed);

        start = System.nanoTime();
        HeapSort.sort(numbers, false, numbers.length).get(0);
        elapsed = (System.nanoTime() - start) / 1000000.00;
        comparatorData.put("HeapSort", elapsed);

        return comparatorData;
    }

}
