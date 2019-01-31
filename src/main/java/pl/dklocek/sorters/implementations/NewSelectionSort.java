package pl.dklocek.sorters.implementations;
import pl.dklocek.sorters.interfaces.SorterN;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewSelectionSort implements SorterN {
    @Override
    public <T> List<T> sort(List<T> input, Comparator<T> comparator) {

        if (input.size() < 2) return input;

        for (int i = 0; i < input.size() - 1; i++) {

            Collections.swap(input, findMin(input, comparator, i), i);

        }

        return input;
    }

    private <T> int findMin(List<T> input, Comparator<T> compare, int start) {

        int index = start;
        T val = input.get(start);

        for (int i = start + 1; i < input.size(); i++) {
            if (compare.compare(input.get(i), val) < 0) {
                index = i;
                val = input.get(i);
            }
        }

        return index;
    }
}
