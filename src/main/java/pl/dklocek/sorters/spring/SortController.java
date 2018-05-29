package pl.dklocek.sorters.spring;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dklocek.sorters.backend.*;

import java.util.List;

@CrossOrigin
@RestController
public class SortController {

    @RequestMapping(value = "/sort")
    public List sorted (@RequestParam(value = "table") String numbersString, @RequestParam("method") String method,
                        @RequestParam(value = "allSteps", required = false) boolean steps) {

        if (numbersString.length() == 0) return null;
        int[] numbersToSort = StringToIntArray.convert(numbersString);

        switch (method) {
            case "bubble":
                return BubbleSort.sort(numbersToSort,steps);
            case "insertion":
                return InsertionSort.sort(numbersToSort,steps);
            case "selection":
                return SelectionSort.sort(numbersToSort,steps);
            default:
                return QuickSort.sort(numbersToSort,steps);
        }



    }
}
