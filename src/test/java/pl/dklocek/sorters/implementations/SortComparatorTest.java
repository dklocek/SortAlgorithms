package pl.dklocek.sorters.implementations;

import org.junit.Assert;
import pl.dklocek.sorters.Comparators.SortComparator;

import java.util.Comparator;

public class SortComparatorTest {

    @org.junit.Test
    public void testCompare() throws Exception {

        String a1 = "Dawid";
        String b1 = "Adam";
        Comparator compare = new SortComparator<>();

        Assert.assertEquals(-1,compare.compare(a1,b1));

    }
}