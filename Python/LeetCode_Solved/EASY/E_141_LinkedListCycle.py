# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from typing import Optional


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        el_set = set()

        while True:
            if head == None:
                return False
            if head not in el_set:
                el_set.add(head)
                head = head.next
            else:
                return True

    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # Алгоритм Флойда
        slow = head
        fast = head.next

        while slow != None and fast != None:
            slow = slow.next
            fast = fast.next

            if fast == None:
                return False
            fast = fast.next

            if slow == fast:
                return True
            
        return False


