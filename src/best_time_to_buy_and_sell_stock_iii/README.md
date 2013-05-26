###[Best Time to Buy and Sell Stock III](http://leetcode.com/onlinejudge#question_123)

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

-

My Solution uses dynamic programming. Have 2 arrays storing the following information:

Array1[i] stores the max profit with one buy and one sell from period 0-i  
Array2[i] stores the max profit with one buy and oen sell from period i-end

Then calcuate max(Array1[i] + Array2[i])

###Question:
What if `x` transactions instead of 2 are allowed?
