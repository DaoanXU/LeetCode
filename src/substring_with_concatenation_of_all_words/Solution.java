package substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (L.length == 0) {
            return null;
        }

        int sLength = L[0].length();
        int allsLength = sLength * L.length;

        HashMap<String, Integer> allWords = new HashMap<String, Integer>();

        for (String s : L) {
            if (allWords.containsKey(s)) {
                allWords.put(s, allWords.get(s) + 1);
            } else {
                allWords.put(s, 1);
            }
        }

        int current = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while ((S.length() - current) >= allsLength) {
            if (hitAll(S, current, allWords, sLength)) {
                result.add(current);
            }
            current += 1;
        }

        return result;
    }

    private boolean hitAll(String S, int index, HashMap<String, Integer> allWords, int step) {

        HashMap<String, Integer> left = new HashMap<String, Integer>(allWords);

        while (left.size() > 0) {
            if (hitOne(S, index, left, step)) {
                index += step;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean hitOne(String S, int index, HashMap<String, Integer> left, int step) {

        String s = S.substring(index, index + step);
        if (left.containsKey(s)) {
            int count = left.get(s);
            if (count == 1) {
                left.remove(s);
            } else {
                left.put(s, left.get(s) - 1);
            }
            return true;
        }
        return false;

    }
}