package pl.dklocek.sorters.backend;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {
    SelectionSort selectionSort = new SelectionSort();
    GenerateIntArray generator = new GenerateIntArray();
    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Selection Sort Test-----------------------------");
        int[] shortTask = {1,200,3,100};
        int[] result = {1,3,100,200};
        assertArrayEquals(result, selectionSort.sort(shortTask));

        int[] none = {};
        result = new int[] {};
        assertArrayEquals(result, selectionSort.sort(none));

        for(int x=0;x<100;x++) {
            int[] random = generator.generateIntArray(200);
            result = random;
            Arrays.sort(result);
            assertArrayEquals(result, selectionSort.sort(random));

        }
    }

}