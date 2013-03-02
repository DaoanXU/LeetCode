package longest_substring_without_repeating_characters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author Daoan XU
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
