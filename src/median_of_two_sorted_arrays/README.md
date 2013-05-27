###[Median of Two Sorted Arrays](http://leetcode.com/onlinejudge#question_4)

There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

-

**Solution 1**

This is the solution I come up with. The idea is as following:   

Say m <= n. Then by compare the midian of A and midian of B, we can exclude ⌈m/2⌉ -1 numbers in A, 
and we can exluce the same numbers in B in the opposite side.
So in O(log n) time, we can cut A into lefting 2 numbers.

And then, within constant time, we can get the median of the rest numbsers.

In my solution, the final step, that when A is left only 2 numbers, is not finished.
The final step is really annoying, which is just a labor work instead of a technique work.
I just use a O(log m) method there.

The solution passes the online test.

And the time complexity should be O(log(min(m,n)))

**Solution 2**

The idea is that we can check an element in A or B is smaller , greater or equal to the median.
So we can seek for the number we need in A in log(n) time, and in B in log(m) time.

So the time complexity is log(m) + log(n).

[Reference](http://www2.myoops.org/course_material/mit/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf)
