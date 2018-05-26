package pl.dklocek.sorters.backend;

public class SelectionSort implements SortMethod{

    @Override
    public int[] sort(int[] numbers) {

        if(numbers.length<2)return numbers;

          int min;
          int temp;
          int[] foundMinAndIndex;
          for(int i = 0 ; i<numbers.length; i++){
              foundMinAndIndex = findMin(numbers,i);
              min = foundMinAndIndex[0];
              temp = numbers[i];
              numbers[i]=min;
              numbers[foundMinAndIndex[1]]=temp;

          }
        return numbers;
    }

    private int[] findMin(int[] array, int arrayIndex){
        int min=array[arrayIndex];
        int index=arrayIndex;
        for(int i =arrayIndex+1; i<array.length;i++){
             if(array[i]<min){
                 min=array[i];
                 index=i;
             }

        }

        return new int[]{min, index};
    }
}
