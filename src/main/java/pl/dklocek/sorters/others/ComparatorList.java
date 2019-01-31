package pl.dklocek.sorters.others;
import org.springframework.stereotype.Component;
import pl.dklocek.sorters.Comparators.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Component
public class ComparatorList {

    private Map<String,Comparator> comparatorMap = new HashMap<>();

    ComparatorList(){
        comparatorMap.put("standard", new SortComparator<>());
        comparatorMap.put("age", new StudentAgeCompare());
        comparatorMap.put("id", new StudentIdCompare());
        comparatorMap.put("name", new StudentNameCompare());
        comparatorMap.put("surname", new StudentSurnameCompare());

    }



    public Map<String, Comparator> getComparatorMapMap() {
        return comparatorMap;
    }
}
