package pl.dklocek.sorters.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dklocek.sorters.backend.BubbleSort;
import pl.dklocek.sorters.backend.SortMethod;
import pl.dklocek.sorters.backend.StringToIntArray;


@RestController
public class SortController {

    SortMethod sortMethod;

    @RequestMapping(value = "/bubble")
    public int[] bubble(@RequestParam("table") String numbersString) {

        if(numbersString.length()==0)return new int[0];
        sortMethod = new BubbleSort();

        return sortMethod.sort(StringToIntArray.StringToIntArray(numbersString));
    }


}
