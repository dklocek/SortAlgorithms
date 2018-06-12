package pl.dklocek.sorters.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

        return SolutionSelector.select(dataToSort,steps,method);
    }

    @RequestMapping(value = "/sortStudent")
    public List sorted(@RequestParam(value = "table") String dataToSort, @RequestParam(value = "sortBy") String sortBy,
                       @RequestParam(value = "allSteps", required = false) boolean steps,
                       @RequestParam("method") String method) {

        String inputData = ("["+dataToSort.substring(1, dataToSort.length())+"]").replaceAll(";",",");
        Student[] students1={};
        ObjectMapper mapper = new ObjectMapper();

        try {
            students1 = mapper.readValue(inputData, Student[].class);

        } catch (IOException e) {
            e.printStackTrace();
            students1[0]= new Student("-1","-1",-1,-1);

        }

        return SolutionSelector.selectStudent(students1,steps,method, sortBy);
    }

    @RequestMapping(value = "/compare")
    public Map compareSorters(@RequestParam(value = "table") String numbersString) {
        System.out.println("jo");
        return CompareSorters.compare(ConvertDataToSort.convertToInt(numbersString));
    }



}
