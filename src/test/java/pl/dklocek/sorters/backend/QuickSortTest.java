package pl.dklocek.sorters.backend;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


public class QuickSortTest {
    QuickSort quickSort = new QuickSort();
    GenerateIntArray generator = new GenerateIntArray();

    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Quick Sort Test-----------------------------");
        int[] shortTask = {1,200,3,100};
        int[] result = {1,3,100,200};
        assertArrayEquals(result,quickSort.sort(shortTask));



        int[] none = {};
        result = new int[] {};
        assertArrayEquals(result,quickSort.sort(none));

        for(int x=0;x<100;x++) {
            int[] random = generator.generateIntArray(200);
            result = random;
            Arrays.sort(result);
            assertArrayEquals(result, quickSort.sort(random));

        }
    }


}