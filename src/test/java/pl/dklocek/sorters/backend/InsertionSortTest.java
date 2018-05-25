package pl.dklocek.sorters.backend;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    InsertionSort insertionSort = new InsertionSort();
    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Insertion Sort Test--------------------------");
        int[] shortTask = {1,200,3,100};
        int[] result = {1,3,100,200};
        assertArrayEquals(result,insertionSort.sort(shortTask));


    }
}