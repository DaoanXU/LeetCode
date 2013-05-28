###[Longest Valid Parentheses](http://leetcode.com/onlinejudge#question_32)

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

For `"(()"`, the longest valid parentheses substring is `"()"`, which has length = `2`.

Another example is `")()())"`, where the longest valid parentheses substring is `"()()"`, which has length = `4`.

-

My solution use a int array to simulate a stack.  
`-1` mean `(`  
`-2` means `)`  
number `x` means there is a valid parentheses subString of length `x` here

When put new `(` or `)` into the stack, do the calculation of numbers.

Get the max number as the result