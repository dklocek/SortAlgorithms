package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.interfaces.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeapSort implements Sorter {
    @Override
    public <T> List<T> sort(List<T> input, Comparator<T> comparator) {

       return sorting(input,comparator,input.size());

    }

    private  static <T> List<T> sorting(List<T> input, Comparator<T> compare, int end) {

        if (input.size() < 2) {
           return input;
        }

        int lastParent = end / 2 - 1;
        int leftChild;
        int rightChild;

        while (lastParent > -1) {
            leftChild = lastParent * 2 + 1;
            if (leftChild + 1 < end) {
                rightChild = lastParent * 2 + 2;

                if (compare.compare(input.get(rightChild),input.get(leftChild))>0 &&
                        compare.compare(input.get(rightChild),input.get(lastParent))>0)
                {
                    Collections.swap(input, rightChild, lastParent);

                }

                if (compare.compare(input.get(leftChild),input.get(rightChild))>0 &&
                        compare.compare(input.get(leftChild),input.get(lastParent))>0)
                {
                    Collections.swap(input, leftChild, lastParent);

                }
            } else {


                if (compare.compare(input.get(leftChild), input.get(lastParent))>0) {
                    Collections.swap(input, leftChild, lastParent);

                }
            }

            lastParent -= 1;
        }

        Collections.swap(input, 0, end - 1);

        if (end > 1)
            sorting(input, compare, end - 1);


        return input;
    }
}
