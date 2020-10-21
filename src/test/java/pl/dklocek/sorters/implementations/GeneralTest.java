package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.Comparators.SortComparator;
import pl.dklocek.sorters.interfaces.Sorter;
import pl.dklocek.sorters.others.SortersList;
import pl.dklocek.sorters.others.TestCase;
import java.util.Comparator;
import java.util.Map;

public class GeneralTest {

    private SortersList sortersList = new SortersList();
    private Map<String, Sorter> sorterMap = sortersList.getSorterMap();
    private Sorter sorter = new BubbleSort();
    private Comparator compare = new SortComparator<>();
    private TestCase testCase = new TestCase();

    @org.junit.Test
    public void test() throws Exception {
        for(Map.Entry<String,Sorter> entry: sorterMap.entrySet()){
            System.out.println("------"+entry.getValue().getClass().getSimpleName()+"---");
            testCase.testCaseOne(entry.getValue(), compare);
        }
    }
}
