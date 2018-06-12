package pl.dklocek.sorters.implementations;

import org.junit.Test;
import pl.dklocek.sorters.others.Student;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HeapSortTest {

    @Test
    public void testSortInt() throws Exception {

        System.out.println("--------------------Heap Sort Test--------------------------");
        System.out.println("-----------------------NUMBERS--------------------------------");

        int[] shortTask = {1, 200, 3, 100};
        int[] result = {1, 3, 100, 200};
        assertArrayEquals(result, HeapSort.sort(shortTask, false, shortTask.length).get(0));
        System.out.println("---Sample OK!---");

        int[] none = {};
        result = new int[]{};
        assertArrayEquals(result, HeapSort.sort(none, false, none.length).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] random = ArrayGenerator.generate(j);
                result = random;
                Arrays.sort(result);
                assertArrayEquals(result, HeapSort.sort(random, false, random.length).get(0));
            }
        }
        System.out.println("---Random OK!---");
        System.out.println("\n");
    }

    @Test
    public void testSortString() throws Exception{

        System.out.println("-----------------------STRINGS--------------------------------");

        String[] shortString = {"Dawid", "Jan", "Adam", "Aaa", "aaa", "Aaz", "aza"};
        String[] resultString = shortString.clone(); Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
        assertArrayEquals(resultString, HeapSort.sort(shortString,false,shortString.length).get(0));
        System.out.println("---Sample OK!---");

        String[] noneString = {};
        resultString = new String[]{};
        assertArrayEquals(resultString, HeapSort.sort(noneString, false,shortString.length).get(0));
        System.out.println("---Empty OK!---");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] random = ArrayGenerator.generateString(j);
                resultString = random;
                Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
                assertArrayEquals(resultString, HeapSort.sort(random, false,random.length).get(0));
            }
        }
        System.out.println("---Random custom generator OK!----");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] random = ArrayGenerator.generateStringApache(j);
                resultString = random;
                Arrays.sort(resultString, String.CASE_INSENSITIVE_ORDER);
                assertArrayEquals(resultString, HeapSort.sort(random, false,random.length).get(0));
            }
        }
        System.out.println("---Random APACHE generator OK!----");
        System.out.println("\n");
    }

    @Test
    public void testSortStudent() throws Exception {
        Student one = new Student("Dawid", "Klocek", 1, 33);
        Student two = new Student("Adam", "Wiśniewski", 3, 22);
        Student three = new Student("Dawid", "Wójcik", 2, 32);
        Student[] testArray = {one,two,three};

        String byName = two.toString()+one.toString()+three.toString();
        String bySurname = one.toString()+two.toString()+three.toString();
        String byId = one.toString()+three.toString()+two.toString();
        String byAge = two.toString()+three.toString()+one.toString();

        Student[] soretd = HeapSort.sort(testArray,false,testArray.length,"name").get(0);
        assertEquals(byName, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );

        soretd = HeapSort.sort(testArray,false,testArray.length,"surname").get(0);
        assertEquals(bySurname, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );

        soretd = HeapSort.sort(testArray,false,testArray.length,"id").get(0);
        assertEquals(byId, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );

        soretd = HeapSort.sort(testArray,false,testArray.length,"age").get(0);
        assertEquals(byAge, soretd[0].toString()+soretd[1].toString()+soretd[2].toString() );


    }



}