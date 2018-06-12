package pl.dklocek.sorters.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dklocek.sorters.implementations.BubbleSort;
import pl.dklocek.sorters.others.CompareSorters;
import pl.dklocek.sorters.others.ConvertDataToSort;
import pl.dklocek.sorters.others.SolutionSelector;
import pl.dklocek.sorters.others.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SortController {

    @RequestMapping(value = "/sort")
    public List sorted1(@RequestParam(value = "table") String dataToSort, @RequestParam("method") String method,
                       @RequestParam(value = "allSteps", required = false) boolean steps) {

        return SolutionSelector.SolutionSelector(dataToSort,steps,method);
    }

    @RequestMapping(value = "/sortStudent")
    public List sorted(@RequestParam(value = "table") String dataToSort) {

        String testowy = ("["+dataToSort.substring(1, dataToSort.length())+"]").replaceAll(";",",");
        System.out.println(testowy.substring(1));
        Student[] students1=null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            Student[] students12 = mapper.readValue(testowy, Student[].class);
            students1=students12;
        } catch (IOException e) {
            e.printStackTrace();
        }

     /*   List<Student> students = Arrays.asList(students1);
        students.add(new Student("Dawid", "klocek", 1, 32));
        students.add(new Student("Dawid", "klocek", 1, 33));
        students.add(new Student("Dawid", "klocek", 1, 34));*/
        return BubbleSort.sortByName(students1,false);
    }

    @RequestMapping(value = "/compare")
    public Map compareSorters(@RequestParam(value = "table") String numbersString) {
        System.out.println("jo");
        return CompareSorters.compare(ConvertDataToSort.convertToInt(numbersString));
    }



}
