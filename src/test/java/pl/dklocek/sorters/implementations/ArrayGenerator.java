package pl.dklocek.sorters.implementations;


import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.util.Random;

public class ArrayGenerator {

    public static Integer[] generate(int numberOfElements) {

        Integer[] intArray = new Integer[numberOfElements];
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {

            intArray[i] = random.nextInt(1000 + 1 + 1000) - 1000;
        }

        return intArray;
    }

    public static String[] generateString(int numberOfWords) {

        String[] stringArray = new String[numberOfWords];
        byte[] array = new byte[10];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {

            random.nextBytes(array);
            stringArray[i] = new String(array, Charset.forName("UTF-8"));

        }

        return stringArray;
    }

    public static String[] generateStringApache(int numberOfWords) {

        String[] stringArray = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {

            stringArray[i] = RandomStringUtils.random(10, true, true);
        }

        return stringArray;
    }
}