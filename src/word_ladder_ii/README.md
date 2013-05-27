###[Word Ladder II](http://leetcode.com/onlinejudge#question_126)

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

* Only one letter can be changed at a time
* Each intermediate word must exist in the dictionary

For example,

Given:  
start = `"hit"`  
end = `"cog"`  
dict = `["hot","dot","dog","lot","log"]`

Return
```
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
```

Note:

All words have the same length.  
All words contain only lowercase alphabetic characters.

-

reference [My Word Ladder](https://github.com/DaoanXU/LeetCode/tree/master/src/word_ladder) for my data structure.  

Add simple non-recursive, stack using path output.