package pl.dklocek.sorters.others;

import pl.dklocek.sorters.implementations.*;

import java.util.List;
import java.util.regex.Pattern;

public class SolutionSelector {

    public static List select(String dataToSort, boolean steps, String method){

        int[] numbersToSort = {};
        String[] stringsToSort = {};
        int sortingDriver = 1;
        dataToSort.trim();

        if (dataToSort.length() == 0) return null;
        if (Pattern.matches("[\\d,-]+", dataToSort)) {
            numbersToSort = ConvertDataToSort.convertToInt(dataToSort);
            sortingDriver = 0;
        } else {
            stringsToSort = ConvertDataToSort.convertToString(dataToSort);
        }

        switch (method) {
            case "bubble":
                if (sortingDriver == 0) return BubbleSort.sort(numbersToSort, steps);
                else return BubbleSort.sort(stringsToSort, steps);
            case "insertion":
                if (sortingDriver == 0) return InsertionSort.sort(numbersToSort, steps);
                else return InsertionSort.sort(stringsToSort, steps);
            case "selection":
                if (sortingDriver == 0) return SelectionSort.sort(numbersToSort, steps);
                else return SelectionSort.sort(stringsToSort, steps);
            case "merge":
                if (sortingDriver == 0) return MergeSort.sort(numbersToSort, steps);
                else return MergeSort.sort(stringsToSort, steps);
            case "heap":
                if (sortingDriver == 0) return HeapSort.sort(numbersToSort, steps, numbersToSort.length);
                else return HeapSort.sort(stringsToSort, steps, stringsToSort.length);
            default:
                if (sortingDriver == 0) return QuickSort.sort(numbersToSort, steps);
                else return QuickSort.sort(stringsToSort, steps);
        }
    }

    public static List selectStudent(Student[] dataToSort, boolean steps, String method, String sortBy) {

        switch (method) {
            case "bubble":
                return BubbleSort.sort(dataToSort, steps, sortBy);
            case "insertion":
                return InsertionSort.sort(dataToSort, steps, sortBy);
            //   case "selection":
            //        return SelectionSort.sort(stringsToSort, steps);
            case "merge":
                return MergeSort.sort(dataToSort, steps, sortBy);
            case "heap":
                return HeapSort.sort(dataToSort, steps, dataToSort.length, sortBy);
            default:
                return QuickSort.sort(dataToSort, steps, sortBy);


        }
    }
}
