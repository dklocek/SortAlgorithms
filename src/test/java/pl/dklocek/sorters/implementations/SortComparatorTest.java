package pl.dklocek.sorters.implementations;

import org.junit.Assert;
import pl.dklocek.sorters.Comparators.SortComparator;

import java.util.Comparator;

public class SortComparatorTest {

    @org.junit.Test
    public void testCompare() {

        String a1 = "Dawid";
        String b1 = "Adam";
        Comparator sortComparator = new SortComparator<>();


        Assert.assertEquals(-1,sortComparator.compare(b1,a1));
        Assert.assertEquals(1,sortComparator.compare(a1,b1));

        a1 = "Test";
        b1 = "Test";

        Assert.assertEquals(0,sortComparator.compare(b1,a1));
        Assert.assertEquals(0,sortComparator.compare(a1,b1));

    }
}