package longest_substring_without_repeating_characters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        Queue<Character> subString = new LinkedList<Character>();
        char[] theString = s.toCharArray();
        for (int i = 0; i < theString.length; i++) {
            Character thisChar = theString[i];
            if (subString.contains(thisChar)) {
                max = count > max ? count : max;
                while (!subString.poll().equals(thisChar)) {
                    count--;
                }
                count--;
            }
            subString.offer(thisChar);
            count++;
        }
        max = count > max ? count : max;
        return max;
    }

}
