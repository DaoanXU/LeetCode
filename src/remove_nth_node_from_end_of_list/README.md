[Remove Nth Node From End of List](http://leetcode.com/onlinejudge#question_19)

Given a linked list, remove the nth node from the end of list and return its head.

For example,

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

Note:  
Given n will always be valid.  
Try to do this in one pass.

-

###Solution2Pointer.java

This uses 2 pointers, one starts to move after the first one have move n nodes forward.  

###SolutionStack.java

This one uses recursion. When n recursive is done, return the cururent node.
