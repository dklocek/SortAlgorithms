package pl.dklocek.sorters.implementations;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void testSort() throws Exception {

        System.out.println("--------------------Selection  Sort Test--------------------------");
        int[] shortTask = {1, 200, 3, 100};
        int[] result = {1, 3, 100, 200};
        assertArrayEquals(result, SelectionSort.sort(shortTask, false).get(0));
        System.out.println("---Sample OK!---");

        int[] none = {};
        result = new int[]{};
        assertArrayEquals(result, SelectionSort.sort(none, false).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] random = ArrayGenerator.generate(j);
                result = random;
                Arrays.sort(result);
                assertArrayEquals(result, SelectionSort.sort(random, false).get(0));
            }
        }
        System.out.println("---Random OK!---");
    }

    @Test
    public void testSortString() throws Exception{
        System.out.println("-----------------------STRINGS--------------------------------");

        String[] shortString = {"Dawid", "Jan", "Adam", "Aaa", "aaa", "Aaz", "aza"};
        String[] resultString = shortString.clone(); Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
        assertArrayEquals(resultString, SelectionSort.sort(shortString,false).get(0));

        String[] noneString = {};
        resultString = new String[]{};
        assertArrayEquals(resultString, SelectionSort.sort(noneString, false).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] random = ArrayGenerator.generateString(j);
                resultString = random;
                Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
                assertArrayEquals(resultString, SelectionSort.sort(random, false).get(0));
            }
        }
        System.out.println("---Random custom generator OK!----");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] random = ArrayGenerator.generateStringApache(j);
                resultString = random;
                Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
                assertArrayEquals(resultString, SelectionSort.sort(random, false).get(0));
            }
        }
        System.out.println("---Random APACHE generator OK!----");
        System.out.println("\n");
    }

}