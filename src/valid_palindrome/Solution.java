package valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^\\p{L}\\p{N}]", "");
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return sb.toString().equals(s);        
    }
}
