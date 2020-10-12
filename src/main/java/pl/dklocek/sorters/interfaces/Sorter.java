package pl.dklocek.sorters.interfaces;

import java.util.Comparator;
import java.util.List;

public interface Sorter {
    <T> List<T> sort(List<T> input, Comparator<T> comparator);
}
