package pl.dklocek.sorters.implementations;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Merge Sort Test--------------------------");
        int[] shortTask = {1, 200, 3, 100};
        int[] result = {1, 3, 100, 200};
        assertArrayEquals(result, (MergeSort.sort(shortTask,false).get(0)));
        System.out.println("---Sample OK!---");

        int[] none = {};
        result = new int[]{};
        assertArrayEquals(result, MergeSort.sort(none, false).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                int[] random = GenerateIntArray.generate(j);
                result = random;
                Arrays.sort(result);
                assertArrayEquals(result, MergeSort.sort(random, false).get(0));
            }
            System.out.println("---Random " + i + " *100 -> OK!---");
        }
    }
}