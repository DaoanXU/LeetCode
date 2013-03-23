[Question Link](http://leetcode.com/onlinejudge#question_30)

###Substring with Concatenation of All Words

You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:  
S: `"barfoothefoobarman"`  
L: `["foo", "bar"]`

You should return the indices: `[0,9]`.  
(order does not matter).

-

My Solution Was using ArrayList to store L, which reaches the time limit. So i switch to HashMap. This the force solution.