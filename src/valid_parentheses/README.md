[Question Link](http://leetcode.com/onlinejudge#question_20)

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

---

From the first char, push all starting chars into the stack.  
And for all closing chars, checks if it matches the top of the stack.   
If so, popt it and continue.  
If not, return false.  

If the stack is not empty when done, return false

