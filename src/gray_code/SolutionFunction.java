package gray_code;

import java.util.ArrayList;

public class SolutionFunction {
    public ArrayList<Integer> grayCode(int n) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = (int) Math.pow(2, n);
        for (int i = 0; i < count; i++)
            result.add((i >>> 1) ^ i);
        return result;
    }

}
