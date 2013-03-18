[Question Link](http://leetcode.com/onlinejudge#question_29)

Divide two integers without using multiplication, division and mod operator.

--

The two solution are acturally the have the same idea.
I first come up the Solution one, which is a recursive version.
However, after modifying it into non-recurisve verion, i found that the mumber of bit operation is reduced.

The solution scans bit by by bit, so its O(32) = O(1).

One tricy thing used is that we change all numbers to negative. And i use the fact that Integer.MAX_VALUE + 1 = Integer.MIN_VALUE, 
and 0 - Integer.MIN_VALUE = Integer.MIN_VALUE. From the algorithm point of view, i did not deal with over flow.
However the 2 facts given above makes the overflow situation "accendtaly" correct.
