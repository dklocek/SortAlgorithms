package pl.dklocek.sorters.Comparators;


import java.util.Comparator;

public class SortComparator<T extends Comparable<T>> implements Comparator<T>  {


    @Override
    public int compare(T o1, T o2) {
        int res = o1.compareTo(o2);

        return Integer.compare(res, 0);

    }

}
