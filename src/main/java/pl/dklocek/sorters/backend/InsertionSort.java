package pl.dklocek.sorters.backend;

public class InsertionSort implements SortMethod{
    @Override
    public int[] sort(int[] numbers) {

        if(numbers.length<2)return numbers;

        int sortedIndex, insertedVariable;
        for(int i =1 ; i<numbers.length ; i++){

            sortedIndex=i;
            insertedVariable=numbers[i];

            while(sortedIndex>0 && numbers[sortedIndex-1]>insertedVariable){
                 numbers[sortedIndex]=numbers[sortedIndex-1];
                sortedIndex--;
            }
            numbers[sortedIndex]=insertedVariable;

        }

        return numbers;
    }
}
