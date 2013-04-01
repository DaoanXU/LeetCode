###[Permutations](http://leetcode.com/onlinejudge#question_46)

Given a collection of numbers, return all possible permutations.

For example,  
`[1,2,3]` have the following permutations:  
`[1,2,3]`, `[1,3,2]`, `[2,1,3]`, `[2,3,1]`, `[3,1,2]`, and `[3,2,1]`.

-

###SolutionStack*.java

These three solutions are simulating the progresses in stack. It have a lot of array coye, so it is slow.  
These are non-recurisve solutions

###SolutionSwapArray.java

This solution swaps the numbers in array in each recursion level.  
It only swaps so it is much faster.
