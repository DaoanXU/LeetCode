package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SolutionUsingHashMap {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        Set set = new HashSet();

        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            mapper.put(num[i], i);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            if ( i < 0)
                break;
            for (int j = i + 1; j < num.length - 1; j++) {
                Integer indexOf = mapper.get(0 - num[i] - num[j]);
                if (indexOf != null) {
                    if (indexOf.compareTo(j) > 0) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[indexOf]);
                        if(set.add(tmp))
                            result.add(tmp);
                    }
                }
            }
        }

        return result;
    }

}