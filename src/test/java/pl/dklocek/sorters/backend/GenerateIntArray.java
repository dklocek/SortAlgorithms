package pl.dklocek.sorters.backend;


import java.util.Random;

public class GenerateIntArray {

    public int[] generateIntArray(int numberOfElements){

        int[] intArray = new int[numberOfElements];

        for(int i=0; i<numberOfElements;i++){
            Random random = new Random();
            intArray[i]=random.nextInt();
        }

        return intArray;
    }
}
