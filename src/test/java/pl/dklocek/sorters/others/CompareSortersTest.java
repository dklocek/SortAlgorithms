package pl.dklocek.sorters.others;

import org.junit.Test;

import java.util.Map;

/**
 * Created by Security on 2018-05-29.
 */
public class CompareSortersTest {

    @Test
    public void testCompare() throws Exception {
        System.out.println("!-----------------------C O M P A R E-----------------!");
        Map map = CompareSorters.compare(new int[]{2,1,6,6,20,15,1,2,-8});
        System.out.println("Bubble: "+map.get("BubbleSort"));
        System.out.println("InsertionSort: "+map.get("InsertionSort"));
        System.out.println("QuickSort: "+map.get("QuickSort"));
        System.out.println("SelectionSort: "+map.get("SelectionSort"));

      //  assertEquals(null,CompareSorters.compare(new int[]{2,1,6,6,20,15,1,2,-8}));
    }
}