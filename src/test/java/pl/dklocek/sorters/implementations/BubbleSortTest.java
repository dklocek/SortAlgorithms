package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.Comparators.SortComparator;
import pl.dklocek.sorters.interfaces.Sorter;
import pl.dklocek.sorters.others.TestCase;

import java.util.*;

public class BubbleSortTest {

    private Sorter sorter = new BubbleSort();
    private Comparator compare = new SortComparator<>();
    private TestCase testCase = new TestCase();

    @org.junit.Test
    public void test() throws Exception {
        testCase.testCaseOne(sorter, compare);
    }
}