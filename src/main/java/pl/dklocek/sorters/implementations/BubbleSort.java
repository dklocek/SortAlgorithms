package pl.dklocek.sorters.implementations;

import pl.dklocek.sorters.others.Student;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static List<int[]> sort(int[] numbers, boolean allSteps) {

        List<int[]> sorted = new ArrayList<>();
        boolean swapMade;

        if (numbers.length < 2) {
            sorted.add(numbers);
            return sorted;
        }

        do {
            swapMade = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    Swap.swap(numbers, i, i + 1);
                    swapMade = true;
                    if (allSteps) sorted.add(numbers.clone());
                }
            }
        } while (swapMade);

        if (!allSteps) sorted.add(numbers);
        return sorted;
    }

    public static List<String[]> sort(String[] table, boolean allSteps){
        List<String[]> sorted = new ArrayList<>();
        boolean swapMade;

        if(table.length<2){
            sorted.add(table);
            return sorted;
        }

        do {
           swapMade=false;

            for(int i = 0 ; i< table.length -1; i++){
                if(table[i].compareToIgnoreCase(table[i+1]) > 0) {
                   Swap.swap(table,i,i+1);
                   swapMade = true;
                    if(allSteps)sorted.add(table);
                }
            }

        } while (swapMade);

        if(!allSteps)sorted.add(table);

        return sorted;
    }

    public static List<Student[]> sort(Student[] students, boolean allSteps, String compareBy){
        List<Student[]> sorted = new ArrayList<>();
        boolean swapMade;

        if(students.length<2){
            sorted.add(students);
            return sorted;
        }
        do{
          swapMade=false;

            for(int i=0; i<students.length -1; i++ ){
                if(students[i].compareBy(students[i+1],compareBy)>0){
                    Swap.swap(students,i,i+1);
                    swapMade=true;
                    if(allSteps)sorted.add(students);
                }
            }
        }while (swapMade);
        if(!allSteps)sorted.add(students);
        return sorted;
    }

}
