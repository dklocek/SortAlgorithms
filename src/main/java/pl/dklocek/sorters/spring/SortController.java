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

    @RequestMapping(value = "/bubble")
    public int[] bubble(@RequestParam("table") String numbersString) {

        if(numbersString.length()==0)return new int[0];
        sortMethod = new BubbleSort();

        return sortMethod.sort(StringToIntArray.StringToIntArray(numbersString));
    }

    @RequestMapping(value = "/insertion")
    public int[] insertion(@RequestParam("table") String numbersString) {

        if(numbersString.length()==0)return new int[0];
        sortMethod = new InsertionSort();

        return sortMethod.sort(StringToIntArray.StringToIntArray(numbersString));
    }

    @RequestMapping(value = "/quick")
    public int[] quick(@RequestParam("table") String numbersString) {

        if(numbersString.length()==0)return new int[0];
        sortMethod = new QuickSort();

        return sortMethod.sort(StringToIntArray.StringToIntArray(numbersString));
    }

    @RequestMapping(value = "/selection")
    public int[] selection(@RequestParam("table") String numbersString) {

        if(numbersString.length()==0)return new int[0];
        sortMethod = new SelectionSort();

        return sortMethod.sort(StringToIntArray.StringToIntArray(numbersString));
    }



}
