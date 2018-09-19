package pl.dklocek.sorters.interfaces;


import pl.dklocek.sorters.others.Student;

import java.util.List;

public interface Sorter {

    List<Integer[]> sort(Integer[] data, Boolean allSteps);
    List<String[]> sort(String[] data, Boolean allSteps);
    List<Student[]> sort(Student[] data, Boolean allSteps, String sortBy);

}
