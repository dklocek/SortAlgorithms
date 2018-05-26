package pl.dklocek.sorters.backend;


public class QuickSort implements SortMethod {

    @Override
    public int[] sort(int[] numbers) {

        if (numbers.length < 2) return numbers;

        int pivot = numbers[numbers.length - 1];
        int i, j, temp;
        i = 0;
        j = 0;

        do {

            if (numbers[i] < pivot) {
                temp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = temp;
                j++;
            }
            i++;

        } while (i < numbers.length);

        if (j == numbers.length - 1) return numbers;
        numbers[numbers.length - 1] = numbers[j];
        numbers[j] = pivot;

        return sort(numbers);
    }
}
