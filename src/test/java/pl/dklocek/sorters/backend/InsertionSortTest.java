package pl.dklocek.sorters.backend;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {

    InsertionSort insertionSort = new InsertionSort();
    GenerateIntArray generator = new GenerateIntArray();

    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Insertion Sort Test--------------------------");
        int[] shortTask = {1,200,3,100};
        int[] result = {1,3,100,200};
        assertArrayEquals(result,insertionSort.sort(shortTask));

        int[] none = {};
        result = new int[] {};
        assertArrayEquals(result,insertionSort.sort(none));

        int[] random = generator.generateIntArray(200);
        result = random;
        Arrays.sort(result);
        assertArrayEquals(result,insertionSort.sort(random));
    }
}