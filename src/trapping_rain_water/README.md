###[Trapping Rain Water](http://leetcode.com/onlinejudge#question_42)

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,   
Given `[0,1,0,2,1,0,1,3,2,1,2,1]`, return `6`.

![](http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png)

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 

-

**SolutionRowByRow**   
Count Row By Row From the bottom. The time complexity is: let there are k different height, the complexity is O(kn)

**Solution**  
calculates the height of water at each column. The time complexity is O(n)