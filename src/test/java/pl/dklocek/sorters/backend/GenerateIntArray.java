package pl.dklocek.sorters.backend;


import java.util.Random;

public class GenerateIntArray {

    public static int[] generate(int numberOfElements){

        int[] intArray = new int[numberOfElements];
        Random random = new Random();
        for(int i=0; i<numberOfElements;i++){

            intArray[i]=random.nextInt(1000 +1 +1000)-1000;
        }

        return intArray;
    }
}