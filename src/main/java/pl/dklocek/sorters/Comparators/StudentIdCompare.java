package pl.dklocek.sorters.Comparators;

import pl.dklocek.sorters.others.Student;

import java.util.Comparator;

public class StudentIdCompare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        return o1.compareBy(o2, "id");

    }
}
