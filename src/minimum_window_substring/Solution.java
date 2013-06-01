package minimum_window_substring;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    Deque<Character> winDeque;
    HashMap<Character, Integer> cMap;
    HashMap<Character, Integer> tMap;
    String minWindow;
    boolean fill;

    public String minWindow(String S, String T) {

        winDeque = new LinkedList<Character>();
        tMap = new HashMap<Character, Integer>();
        cMap = new HashMap<Character, Integer>();
        minWindow = null;
        fill = false;

        for (int i = 0; i < T.length(); i++) {
            Character currentC = T.charAt(i);
            if (!tMap.containsKey(currentC))
                tMap.put(currentC, 1);
            else
                tMap.put(currentC, tMap.get(currentC) + 1);
        }

        for (int i = 0; i < S.length(); i++) {
            Character currentC = S.charAt(i);
            winDeque.offer(currentC);
            if (tMap.containsKey(currentC)) {
                Integer tmp = cMap.get(currentC);
                cMap.put(currentC, tmp == null ? 1 : tmp + 1);
                if (fill())
                    tryPop();
            }
        }

        return minWindow == null ? "" : minWindow;
    }

    private boolean fill() {
        if (fill)
            return true;

        if (cMap.size() < tMap.size())
            return false;

        for (Character key : cMap.keySet()) {
            if (cMap.get(key) < tMap.get(key))
                return false;
        }
        fill = true;
        return true;
    }

    private void tryPop() {

        Character first = winDeque.peek();
        Integer firstCount = cMap.get(first);
        while (firstCount == null || firstCount > tMap.get(first)) {
            winDeque.pop();
            if (firstCount != null)
                cMap.put(first, firstCount - 1);
            first = winDeque.peek();
            firstCount = cMap.get(first);
        }

        if (minWindow == null || minWindow.length() > winDeque.size()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : winDeque)
                sb.append(c);
            minWindow = sb.toString();
        }
    }
}
