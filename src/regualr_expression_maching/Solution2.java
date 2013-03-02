package regualr_expression_maching;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: 
 * isMatch("aa","a") �� false 
 * isMatch("aa","aa") �� true
 * isMatch("aaa","aa") �� false 
 * isMatch("aa", "a*") �� true 
 * isMatch("aa", ".*") �� true 
 * isMatch("ab", ".*") �� true 
 * isMatch("aab", "c*a*b") �� true
 * 
 * @author Daoan XU
 * 
 */

public class Solution2 {
    
    public boolean isMatch(String s, String p) {

        if (s.length() == 0) {
            if (p.length() == 0)
                return true;
            if (p.length() == 1)
                return false;
            if (p.length() > 1)
                if (p.charAt(1) == '*')
                    return isMatch(s, p.substring(2));
                else
                    return false;
        }

        if (p.length() == 0)
            return false;

        char s0 = s.charAt(0);
        char p0 = p.charAt(0);
        char p1;
        if (p.length() > 1)
            p1 = p.charAt(1);
        else
            p1 = '\0';

        if (s0 == p0 || p0 == '.') {
            if (p1 == '*')
                return isMatch(s.substring(1), p)
                        || isMatch(s, p.substring(2));
            return isMatch(s.substring(1), p.substring(1));
        }

        if (p1 == '*') {
            return isMatch(s, p.substring(2));
        }

        return false;
    }
}
