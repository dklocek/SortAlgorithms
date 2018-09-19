package pl.dklocek.sorters.others;

import org.springframework.stereotype.Component;
import pl.dklocek.sorters.implementations.*;
import pl.dklocek.sorters.interfaces.Sorter;

import java.util.HashMap;
import java.util.Map;

@Component
public class SortersList {

    private Map<String,Sorter> sorterMap = new HashMap<>();

    SortersList(){
        sorterMap.put("bubble", new BubbleSort());
        sorterMap.put("insertion", new InsertionSort());
        sorterMap.put("quick", new QuickSort());
        sorterMap.put("selection", new SelectionSort());
        sorterMap.put("merge", new MergeSort());
        sorterMap.put("heap", new HeapSort());
    }



    public Map<String, Sorter> getSorterMap() {
        return sorterMap;
    }
}
