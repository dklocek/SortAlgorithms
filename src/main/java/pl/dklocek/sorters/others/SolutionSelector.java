package pl.dklocek.sorters.others;

import pl.dklocek.sorters.interfaces.Sorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class SolutionSelector {

   public static List select(String dataToSort, boolean steps, String method, SortersList sortersList, Comparator compare){

        dataToSort = dataToSort.trim();
        Sorter sorter = sortersList.getSorterMap().get(method);

        if (dataToSort.length() == 0) return null;
        if (Pattern.matches("[\\d,-]+", dataToSort)) {
            return sorter.sort(Arrays.asList(ConvertDataToSort.convertToInt(dataToSort)),compare);
        } else {
            return sorter.sort(Arrays.asList(ConvertDataToSort.convertToString(dataToSort)),compare);
        }

    }

    public static List selectStudent(Student[] students, boolean steps, String method, SortersList sortersList, Comparator compare) {

        return sortersList.getSorterMap().get(method).sort(Arrays.asList(students), compare);


    }
}
