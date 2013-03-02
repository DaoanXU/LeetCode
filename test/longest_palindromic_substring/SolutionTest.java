package longest_palindromic_substring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    public Solution doit;

    @Before
    public void init() {
        doit = new Solution();
    }

    @Test
    public void test0() {
        System.out.println(doit.longestPalindrome("a"));
    }

}
