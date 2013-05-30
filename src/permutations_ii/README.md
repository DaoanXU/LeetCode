###[Permutations II](http://leetcode.com/onlinejudge#question_47)

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,  
`[1,1,2]` have the following unique permutations:
`[1,1,2]`, `[1,2,1]`, and `[2,1,1]`.

-

###SolutionSet.java

This one Reuse the [SolutionSwapArray.java](https://github.com/DaoanXU/LeetCode/blob/master/src/permutations/SolutionSwapArray.java) in [Permutations](https://github.com/DaoanXU/LeetCode/tree/master/src/permutations). Simply add set to check duplication.

###SolutionWrongButPassMost.java

This one uses the idea the same as the following one. But it is wrong. However, only one of the test make it fails. Ant it is fast. It is based on [SolutionSwapArray.java](https://github.com/DaoanXU/LeetCode/blob/master/src/permutations/SolutionSwapArray.java) in [Permutations](https://github.com/DaoanXU/LeetCode/tree/master/src/permutations).

###Solution.java

This one is based on [SolutionRecursive](https://github.com/DaoanXU/LeetCode/blob/master/src/permutations/SolutionRecursive.java) in [Permutations](https://github.com/DaoanXU/LeetCode/tree/master/src/permutations). Small modification is made to make things work correctly.

