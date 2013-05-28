package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Set set = new HashSet();

        for (int i = 0; i < num.length; i++) {
            if (i < 0)
                break;
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[left]);
                    tmp.add(num[right]);
                    if(set.add(tmp))
                        result.add(tmp);
                    right--;
                    left++;
                    continue;
                }
            }
        }

        return result;
    }

}
