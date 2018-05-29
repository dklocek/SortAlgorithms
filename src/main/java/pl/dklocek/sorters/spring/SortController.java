package pl.dklocek.sorters.spring;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dklocek.sorters.backend.*;

@CrossOrigin
@RestController
public class SortController {

    SortMethod sortMethod;

    @RequestMapping(value = "/sort")
    public int[] bubble(@RequestParam("table") String numbersString, @RequestParam("method") String method) {

        if(numbersString.length()==0)return new int[0];

        switch (method){
            case "bubble":  sortMethod = new BubbleSort();
            case "insertion": sortMethod = new InsertionSort();
            case "selection": sortMethod= new SelectionSort();
            default: sortMethod = new QuickSort();
        }
        sortMethod = new BubbleSort();

        return sortMethod.sort(StringToIntArray.StringToIntArray(numbersString));
    }



}
