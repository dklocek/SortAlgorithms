package pl.dklocek.sorters.others;


import pl.dklocek.sorters.interfaces.Sorter;

import java.util.HashMap;
import java.util.Map;

public class CompareSorters {

    private static Map<String, Double> comparatorData = new HashMap<>();
    private static String[] sortingNames = new String[]{"","bubble","insertion","quick","selection",
            "merge","heap"};


    public static Map compare(Integer[] numbers, SortersList sortersList) {

        Long start;
        Double elapsed;

        for(int i =1; i<sortersList.getSorterMap().size();i++){
            Sorter sorter = sortersList.getSorterMap().get(sortingNames[i]);
            start = System.nanoTime();

            sorter.sort(numbers,false);

            elapsed = (System.nanoTime() - start) / 1000000.00;
            comparatorData.put(sortingNames[i], elapsed);
        }

        return comparatorData;
    }

}
