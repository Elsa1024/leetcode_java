# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        node_0 = head_0 = ListNode(-1)
        node_1 = head_1 = ListNode(-1)
        node = head
      
        while node != None:
            if node.val < x:
                node_0.next = node
                node = node.next
                node_0 = node_0.next
            else:
                node_1.next = node
                node = node.next
                node_1 = node_1.next
        
        node_0.next = head_1.next
        node_1.next = None
        return head_0.next
