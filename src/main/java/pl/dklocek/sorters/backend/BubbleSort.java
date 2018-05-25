package pl.dklocek.sorters.backend;

public class BubbleSort implements SortMethod {

    @Override
    public int[] sort(int[] numbers) {
        int temp;
        boolean swapMade = false;

        if(numbers.length==1)return numbers;


        do {
            swapMade=false;

            for(int i=0 ; i<numbers.length-1; i++){
                if(numbers[i]>numbers[i+1]){
                    temp = numbers[i+1];
                    numbers[i+1]=numbers[i];
                    numbers[i]=temp;
                    swapMade=true;
                }
            }
        } while (swapMade);


        return numbers;
    }
}
