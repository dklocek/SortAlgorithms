package pl.dklocek.sorters.spring;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dklocek.sorters.others.CompareSorters;
import pl.dklocek.sorters.others.ConvertDataToSort;
import pl.dklocek.sorters.others.SolutionSelector;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SortController {

    @RequestMapping(value = "/sort")
    public List sorted(@RequestParam(value = "table") String dataToSort, @RequestParam("method") String method,
                       @RequestParam(value = "allSteps", required = false) boolean steps) {

        return SolutionSelector.SolutionSelector(dataToSort,steps,method);
    }


    @RequestMapping(value = "/compare")
    public Map compareSorters(@RequestParam(value = "table") String numbersString) {
        System.out.println("jo");
        return CompareSorters.compare(ConvertDataToSort.convertToInt(numbersString));
    }

}
