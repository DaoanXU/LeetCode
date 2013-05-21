###[4 Sum](http://leetcode.com/onlinejudge#question_18)

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

**Note:**

* Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
* The solution set must not contain duplicate quadruplets

```
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
```
 
-

###Common in two solutions
In both solutions, the first step is to generate all the 2sum pairs.
And then do different things

###Solution2
This is a bad solution, it compares all 2sum pairs. There are N^2 2sum pairs.
So the total complexity is N^4

###Solution1
This solution first sort the 2Sum pairs by the sum. And check one by one from both ends.
Usually there are not a lot of pairs with same sum. So the average time complexity is O(N^2LogN).

When There are two large groups, that for all pairs in the same group the sum is the same, and the two value sums to the target, the complexity will be high.
For example the target is 3 and N^2/C pairs sums to 1 and N^2/C pairs sums to 2, the time complexity will be O(N^4). However, this complexity is inevitable in this case.

So this is still an acceptable solution.
