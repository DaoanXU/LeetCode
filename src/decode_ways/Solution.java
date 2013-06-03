package decode_ways;

import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer> ways = new ArrayList<Integer>();
    static {
        ways.add(1);
        ways.add(1);
    }

    public int numDecodings(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int count = 0;
        int sum = 1;
        boolean isOne = false;

        for (char c : s.toCharArray()) {
            int current = c - '0';
            switch (current) {
            case 0:
                if (count == 0)
                    return 0;
                sum *= getWays(count - 1);
                count = 0;
                break;
            case 1:
                count++;
                isOne = true;
                break;
            case 2:
                count++;
                isOne = false;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                if (count > 0)
                    sum *= (getWays(count) + getWays(count - 1));
                count = 0;
                break;
            case 7:
            case 8:
            case 9:
                if (count > 0)
                    if (isOne)
                        sum *= (getWays(count) + getWays(count - 1));
                    else
                        sum *= getWays(count);
                count = 0;
                break;
            default:
                return 0;
            }
        }
        if (count > 0)
            sum *= getWays(count);
        return sum;
    }

    int getWays(int x) {
        if (x < ways.size())
            return ways.get(x);

        ways.add(getWays(x - 2) + getWays(x - 1));
        return ways.get(x);
    }
}