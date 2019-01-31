package pl.dklocek.sorters.implementations;

import org.junit.Assert;
import pl.dklocek.sorters.Comparators.SortComparator;
import pl.dklocek.sorters.Comparators.StudentAgeCompare;
import pl.dklocek.sorters.Comparators.StudentIdCompare;
import pl.dklocek.sorters.interfaces.SorterN;
import pl.dklocek.sorters.others.Student;

import java.util.*;

public class BubbleSortTest {

    SorterN sorter = new NewSelectionSort();
    Comparator compare = new SortComparator<>();

    @org.junit.Test
    public void testSort() throws Exception {

        List<Object> objectList1 = new ArrayList<>();
        Assert.assertEquals(objectList1, sorter.sort(objectList1, compare));

        objectList1.add(new Object());
        Assert.assertEquals(objectList1, sorter.sort(objectList1, compare));

        Integer[] a1 = {2,0,3,4,8,5};
        Integer[] a2 = {0,2,3,4,5,8};

        Assert.assertEquals(Arrays.asList(a2), sorter.sort(Arrays.asList(a1),compare));

        String[] b1 = {"Daniel", "Zen", "As"};
        String[] b2 = {"As","Daniel","Zen"};

        Assert.assertEquals(Arrays.asList(b2), sorter.sort(Arrays.asList(b1),compare));

        List<Student> name1 = new ArrayList<>();

        name1.add(new Student("Dawid","Klocek",1,33));
        name1.add(new Student("Adam","Zielony",3,22));
        name1.add(new Student("Zenon","Kowalski",2,23));

        List<Student> name2 = name1.subList(0,3);
        Collections.sort(name2);

        System.out.println();
        Assert.assertEquals(name2, sorter.sort(name1,compare));

        Student student1 = new Student("Dawid","Klocek",1,33);
        Student student2 = new Student("Adam","Zielony",3,22);
        Student student3 = new Student("Zenon","Kowalski",2,23);

        name1= new ArrayList<>();
        name1.add(student1);
        name1.add(student2);
        name1.add(student3);

        name2= new ArrayList<>();
        name2.add(student1);
        name2.add(student3);
        name2.add(student2);

        Assert.assertEquals(name2,sorter.sort(name1, new StudentIdCompare()));

        name1= new ArrayList<>();
        name1.add(student1);
        name1.add(student2);
        name1.add(student3);

        name2= new ArrayList<>();
        name2.add(student2);
        name2.add(student3);
        name2.add(student1);

        Assert.assertEquals(name2,sorter.sort(name1, new StudentAgeCompare()));

    }
}