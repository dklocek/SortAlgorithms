package pl.dklocek.sorters.implementations;

import org.junit.Test;
import pl.dklocek.sorters.others.Student;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleSortTest {

    @Test
    public void testSortInt() throws Exception {

        System.out.println("--------------------Bubble Sort Test--------------------------");
        System.out.println("-----------------------NUMBERS--------------------------------");

        int[] shortTask = {1, 200, 3, 100};
        int[] result = {1, 3, 100, 200};
        assertArrayEquals(result, BubbleSort.sort(shortTask, false).get(0));
        System.out.println("---Sample OK!---");

        int[] none = {};
        result = new int[]{};
        assertArrayEquals(result, BubbleSort.sort(none, false).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] random = ArrayGenerator.generate(j);
                result = random;
                Arrays.sort(result);
                assertArrayEquals(result, BubbleSort.sort(random, false).get(0));
            }
        }
        System.out.println("---Random OK!---");
        System.out.println("\n");
    }

    @Test
    public void testSortString() throws Exception {

        System.out.println("-----------------------STRINGS--------------------------------");

        String[] shortString = {"Dawid", "Jan", "Adam", "aaa", "Aaa", "Aaz", "aza"};
        String[] resultString = shortString.clone(); Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
        assertArrayEquals(resultString, BubbleSort.sort(shortString,false).get(0));

        String[] noneString = {};
        resultString = new String[]{};
        assertArrayEquals(resultString, BubbleSort.sort(noneString, false).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] random = ArrayGenerator.generateString(j);
                resultString = random;
                Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
                assertArrayEquals(resultString, BubbleSort.sort(random, false).get(0));
            }
        }
        System.out.println("---Random custom generator OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] random = ArrayGenerator.generateStringApache(j);
                resultString = random;
                Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
                assertArrayEquals(resultString, BubbleSort.sort(random, false).get(0));
            }
        }
        System.out.println("---Random APACHE generator OK!---");
        System.out.println("\n");

    }

    @Test
    public void testSortStudent() throws Exception{
        Student one = new Student("Dawid", "Klocek", 1, 33);
        Student two = new Student("Adam", "Wiśniewski", 3, 22);
        Student three = new Student("Dawid", "Wójcik", 2, 32);
        Student[] testArray = {one,two,three};

        String byName = two.toString()+one.toString()+three.toString();
        String bySurname = one.toString()+two.toString()+three.toString();
        String byId = one.toString()+three.toString()+two.toString();
        String byAge = two.toString()+three.toString()+one.toString();

        Student[] soretd = BubbleSort.sort(testArray,false,"name").get(0);
        assertEquals(byName, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );

        soretd = BubbleSort.sort(testArray,false,"surname").get(0);
        assertEquals(bySurname, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );

        soretd = BubbleSort.sort(testArray,false,"id").get(0);
        assertEquals(byId, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );

        soretd = BubbleSort.sort(testArray,false,"age").get(0);
        assertEquals(byAge, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );




    }
}