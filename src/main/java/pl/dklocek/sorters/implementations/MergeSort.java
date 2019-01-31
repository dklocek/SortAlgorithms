package pl.dklocek.sorters.implementations;
import pl.dklocek.sorters.interfaces.SorterN;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements SorterN {

   @Override
    public <T> List<T> sort(List<T> input, Comparator<T> comparator) {

        if (input.size() < 2) {
            return input;
        }

        mergeSort(0, input.size()-1, input, comparator);

        return input;
    }

    static <T> void  mergeSort(int start, int end, List<T> input, Comparator<T> comparator ) {

        int middle;

        if (start < end) {
            middle = (end + start) / 2;
            mergeSort(start, middle, input, comparator);
            mergeSort(middle + 1, end, input, comparator);
            merge(start, middle, end, input, comparator);

        }
    }

    static <T> void merge(int start, int middle, int end, List<T> input, Comparator<T> compare) {

        List<T> temp= new ArrayList<>();

        for (T x:input) {
            temp.add(x);
        }

        int i = start;
        int j = middle + 1;
        int x = start;

        while (i <= middle && j <= end) {
            if (compare.compare(temp.get(i),temp.get(j))<0)
                input.set(x++, temp.get(i++));
            else
                input.set(x++,temp.get(j++));
        }

        while (i <= middle) input.set(x++,temp.get(i++));
        while (j <= end) input.set(x++,temp.get(j++));

    }
}
