package longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        int i = 0;
        try {
            while (true) {
                char thisone = strs[0].charAt(i);
                boolean breakit = false;
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) != thisone) {
                        breakit = true;
                        break;
                    }
                }
                if (breakit)
                    break;
                i++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return strs[0].substring(0, i);
    }
}