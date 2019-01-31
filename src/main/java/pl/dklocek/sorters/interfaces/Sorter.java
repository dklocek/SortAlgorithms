package pl.dklocek.sorters.interfaces;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Security on 2018-10-02.
 */
public interface Sorter {
    <T> List<T> sort(List<T> input, Comparator<T> comparator);
}
