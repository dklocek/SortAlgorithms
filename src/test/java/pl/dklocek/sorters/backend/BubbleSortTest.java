package pl.dklocek.sorters.backend;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    BubbleSort bubbleSort = new BubbleSort();
    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Bubble Sort Test-----------------------------");
        int[] shortTask = {1,200,3,100};
        int[] result = {1,3,100,200};
        assertArrayEquals(result,bubbleSort.sort(shortTask));

        int[] none = {};
        result = new int[] {};
        assertArrayEquals(result,bubbleSort.sort(none));

    }


}