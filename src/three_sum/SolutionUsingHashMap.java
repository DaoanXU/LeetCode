package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This solution is O(N^2)
 * However, it reaches the time limit.
 * 
 * @author Daoan XU
 * 
 */
public class SolutionUsingHashMap {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        Arrays.sort(num);

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
                        addToList(result, tmp);
                    }
                }
            }
        }

        return result;
    }

    void addToList(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp) {
        int size = result.size();
        for (int i = 0; i < size; i++) 
            if (isSame(result.get(i), tmp)) 
                return ;
        result.add(tmp);
    }

    <T extends Comparable<T>> boolean isSame(ArrayList<T> a, ArrayList<T> b) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (a.get(i)!= b.get(i))
                return false;
        }
        return true;
    }
}