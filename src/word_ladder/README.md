###[Word Ladder](http://leetcode.com/onlinejudge#question_127)

Given two words (*start* and *end*), and a dictionary, find the length of shortest transformation sequence from *start* to *end*, such that:

* Only one letter can be changed at a time
* Each intermediate word must exist in the dictionary

For example,

Given:  
start = `"hit"`  
end = `"cog"`  
dict = `["hot","dot","dog","lot","log"]`

As one shortest transformation is `"hit" -> "hot" -> "dot" -> "dog" -> "cog"`,  
return its length `5`.

Note:

* Return 0 if there is no such transformation sequence.
* All words have the same length.
* All words contain only lowercase alphabetic characters.

-

My Solution uses map of "connections between partial of words and words" instead of "connections between words". For Example:

`["hot","dot","dog"]`

forms map:

`_ot` -> `["hot","dot"]`  
`h_t` -> `["hot"]`  
`ho_` -> `["hot"]`  
`d_t` -> `["dot"]`  
`do_` -> `["dot","dog"]`  
...

When i need connected words of `"dot"`, I combines value set of  
`_ot` -> `["hot","dot"]`  
`d_t` -> `["dot"]`  
`do_` -> `["dot","dog"]`  

and gets  `["hot","dot","dog"]`

Given word length k, dictionary size n, time complexity is O(k*n)