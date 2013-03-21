[Question Link](http://leetcode.com/onlinejudge#question_53)

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array `[−2,1,−3,4,−1,2,1,−5,4]`,
the contiguous subarray `[4,−1,2,1]` has the largest sum = `6`.

-

###Solution 1:  
Change the problem into the stock max profit in one day problem, by replace each slot with the sum of all slot before it, and add a 0 in the start.

For example, given the array `[−2,1,−3,4,−1,2,1,−5,4]`, change it into   
`[0,−2,-1,−4,0,−1,1,2,-3,1]`  
So the max profit is `2` - `-4` = 6.

###Solution 2:
Combine the array switch step and the later step, in Solution 1, into one loop.   
The solution 1 is easier to understand for me. However, Solution 2 can be explained without Solution 1
