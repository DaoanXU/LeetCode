package gray_code;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if (n == 0)
            return result;

        int adder = 1;

        while (n > 0) {
            for (int i = result.size() - 1; i > -1; i--)
                result.add(adder + result.get(i));
            adder <<= 1;
            n--;
        }

        return result;
    }
}