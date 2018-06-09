package pl.dklocek.sorters.implementations;

import org.junit.Assert;
import org.junit.Test;
import pl.dklocek.sorters.others.Student;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

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
        Student[] testArray = {new Student("Dawid", "Klocek", 1, 33), new Student("Adam", "Wiśniewski", 3, 22),
                new Student("Dawid", "Wójcik", 2, 32)};
        Student[] sorted;

        sorted = testArray.clone();
        Arrays.sort(sorted, Student::compareByName);
        Assert.assertArrayEquals(sorted, HeapSort.sortByName(testArray, false,testArray.length).get(0));

        sorted = testArray.clone();
        Arrays.sort(sorted, Student::compareBySurname);
        Assert.assertArrayEquals(sorted,HeapSort.sortBySurname(testArray,false, testArray.length).get(0));

        sorted = testArray.clone();
        Arrays.sort(sorted, Student::compareById);
        Assert.assertArrayEquals(sorted,HeapSort.sortById(testArray,false, testArray.length).get(0));

        sorted = testArray.clone();
        Arrays.sort(sorted, Student::compareByAge);
        Assert.assertArrayEquals(sorted,HeapSort.sortByAge(testArray,false, testArray.length).get(0));
    }



}