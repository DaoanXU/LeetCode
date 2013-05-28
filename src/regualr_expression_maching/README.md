###[Regular Expression Matching](http://leetcode.com/onlinejudge#question_10)

Implement regular expression matching with support for `'.'` and `'*'`.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") ? false
    isMatch("aa","aa") ? true
    isMatch("aaa","aa") ? false
    isMatch("aa", "a*") ? true
    isMatch("aa", ".*") ? true
    isMatch("ab", ".*") ? true
    isMatch("aab", "c*a*b") ? true

-

Solution 1 replace `aa*` with `a*`, which is a bit faster

Solution 2 just force resursion when shifting / reduce.
