package pl.dklocek.sorters.interfaces;
@FunctionalInterface
public interface SortInterface<F,T, Boolean> {

    F sort(T data, Boolean allSteps);

}
