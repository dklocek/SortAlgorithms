package pl.dklocek.sorters.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dklocek.sorters.others.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@CrossOrigin
@RestController

public class SortController {

    @Autowired
    SortersList sortersList;

    @Autowired
    ComparatorList comparatorList;

    @RequestMapping(value = "/")
    public String index() {

        return "Please use /sort or /sortStudent";
    }

    @RequestMapping(value = "/sort")
    public List sorted1(@RequestParam(value = "table") String dataToSort, @RequestParam("method") String method,
                       @RequestParam(value = "allSteps", required = false) boolean steps) {

        return SolutionSelector.select(dataToSort,steps,method, sortersList, comparatorList.getComparatorMapMap().get("standard"));
    }

    @RequestMapping(value = "/sortStudent")
    public List sorted(@RequestParam(value = "table") String dataToSort, @RequestParam(value = "sortBy") String sortBy,
                       @RequestParam(value = "allSteps", required = false) boolean steps,
                       @RequestParam("method") String method) {

        String inputData = ("["+dataToSort.substring(0, dataToSort.length())+"]").replaceAll(";",",");
        Student[] students1={};
        ObjectMapper mapper = new ObjectMapper();

        try {
            students1 = mapper.readValue(inputData, Student[].class);

        } catch (IOException e) {
            e.printStackTrace();
            students1[0]= new Student("-1","-1",-1,-1);

        }

        return SolutionSelector.selectStudent(students1,steps,method, sortersList, comparatorList.getComparatorMapMap().get(sortBy));
    }

    @RequestMapping(value = "/compare")
    public Map compareSorters(@RequestParam(value = "table") String numbersString) {
        System.out.println("jo");
        return CompareSorters.compare(ConvertDataToSort.convertToInt(numbersString), sortersList);
    }

    @RequestMapping(value = "/test")
    public String JustATest() {

        return "I'm working!";
    }



}
