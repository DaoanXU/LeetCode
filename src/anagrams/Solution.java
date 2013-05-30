package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    /**
     * Wrong Under Standing, useless
     * 
     * @param in
     * @return
     */
    String toSmallest(String in) {
        char minChar = 'z' + 1;
        int minIndex = in.length();
        boolean refresh = true;

        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) < minChar) {
                minIndex = i;
                refresh = false;
                minChar = in.charAt(i);
            }
            else if (in.charAt(i) == minChar) {
                if (refresh) {
                    minIndex = i;
                    refresh = false;
                }
            }
            else {
                refresh = true;
            }
        }
        return in.substring(minIndex) + in.substring(0, minIndex);
    }

    String toSmallest2(String in) {
        char[] it = in.toCharArray();
        Arrays.sort(it);
        return Arrays.toString(it);
    }

    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        for (String str : strs) {
            String min = toSmallest2(str);
            ArrayList<String> tmp = map.get(min);
            if (tmp == null) {
                tmp = new ArrayList<String>();
                map.put(min, tmp);
            }
            tmp.add(str);
        }
        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1)
                result.addAll(tmp);
        }
        return result;
    }

}
