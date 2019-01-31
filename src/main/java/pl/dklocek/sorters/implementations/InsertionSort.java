package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Security on 2019-01-31.
 */
public class InsertionSort implements Sorter {

    @Override
    public <T> List<T> sort(List<T> input, Comparator<T> compare) {


        if (input.size() < 2) {

            return input;
        }

        int sortedIndex;
        T insertedVariable;

        for (int i = 1; i < input.size(); i++) {

            sortedIndex = i;
            insertedVariable = input.get(i);

            while (sortedIndex > 0 && compare.compare(input.get(sortedIndex - 1), insertedVariable)>0) {
                input.set(sortedIndex, input.get(sortedIndex-1));
                sortedIndex--;
            }
            input.set(sortedIndex,insertedVariable);


        }

        return input;
    }
}
