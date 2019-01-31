package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BubbleSort implements Sorter {
    @Override
    public <T> List<T> sort(List<T> input, Comparator<T> compare) {

        boolean swapMade;

        if (input.size() < 2) {

            return input;
        }

        do {
            swapMade = false;

            for (int i = 0; i < input.size() - 1; i++) {
                if (compare.compare(input.get(i),input.get(i+1))>0) {
                    Collections.swap(input,i,i+1);
                    swapMade = true;

                }
            }
        } while (swapMade);

        return input;

    }
}
