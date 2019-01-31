package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort implements Sorter {
    @Override
    public <T> List<T> sort(List<T> numbers, Comparator<T> comparator) {

        if (numbers.size() < 2) {

            return numbers;
        }


        return sorting(numbers, 0, numbers.size() - 1, comparator);


    }

    public static <T> List<T> sorting(List<T> numbers, int start, int end, Comparator<T> compare) {
        T pivot = numbers.get(end);
        int j = start;
        T temp;

        if (j < end) {
            for (int i = j; i < end; i++) {

                if (compare.compare(numbers.get(i), pivot) <= 0) {
                    Collections.swap(numbers, i, j);
                    j++;

                }

            }

            temp = numbers.get(j);
            numbers.set(j, pivot);
            numbers.set(end, temp);

            if (((j - 1) - start) < end - (j + 1)) {

                if (j > start && j > 0) sorting(numbers, start, j - 1, compare);

                    sorting(numbers, j + 1, end, compare);
            }

            else sorting(numbers, j + 1, end, compare);

            if(j>0)sorting(numbers, start, j - 1, compare);
        }

        return numbers;
    }

}
