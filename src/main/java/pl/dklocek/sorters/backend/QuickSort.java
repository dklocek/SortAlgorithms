package pl.dklocek.sorters.backend;


public class QuickSort implements SortMethod {
    int[] numbers;

    @Override
    public int[] sort(int[] numbers) {

        if (numbers.length < 2) return numbers;

        this.numbers = numbers;
        sorting(0, numbers.length - 1);
        return numbers;
    }

    public void sorting(int start, int end) {
        int pivot = numbers[end];
        int j = start;
        int temp;

        if (j < end) {
            //partycjonowanie
            for (int i = 0; i < end; i++) {

                if (numbers[i] <= pivot) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    j++;
                }

            }

            temp = numbers[j];
            numbers[j] = pivot;
            numbers[end] = temp;


            sorting(start, j - 1);
            sorting(j + 1, end);

        }


    }
}
