package pl.dklocek.sorters.interfaces;

@FunctionalInterface
public interface SortStringsInterface<F,T, Boolean, String> {

    F sort(T data, Boolean allSteps, String sortBy);

}
