###[Container With Most Water](http://leetcode.com/onlinejudge#question_11)

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

-

This Solution Contains 2 Solutions.

maxArea is the first idea i come up with, which is recursive solution. It is correct but it reaches the space limit of online test. Recurisve solution may cause stack over flow.

maxAres2 is the O(n) solution which scan from two ends. IT passes the online test
