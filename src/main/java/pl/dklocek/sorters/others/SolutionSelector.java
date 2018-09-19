package pl.dklocek.sorters.others;

import pl.dklocek.sorters.interfaces.Sorter;

import java.util.List;
import java.util.regex.Pattern;

public class SolutionSelector {

   public static List select(String dataToSort, boolean steps, String method, SortersList sortersList){

        dataToSort = dataToSort.trim();
        Sorter sorter = sortersList.getSorterMap().get(method);

        if (dataToSort.length() == 0) return null;
        if (Pattern.matches("[\\d,-]+", dataToSort)) {
            return sorter.sort(ConvertDataToSort.convertToInt(dataToSort),steps);
        } else {
            return sorter.sort(ConvertDataToSort.convertToString(dataToSort),steps);
        }

    }

    public static List selectStudent(Student[] students, boolean steps, String method, String sortBy, SortersList sortersList) {

        return sortersList.getSorterMap().get(method).sort(students,steps,sortBy);


    }
}
