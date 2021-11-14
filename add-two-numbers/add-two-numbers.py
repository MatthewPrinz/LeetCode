# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = False
        result = ListNode()
        resultcopy = result
        while l1 is not None or l2 is not None:
            part1 = l1.val if l1 is not None else 0
            part2 = l2.val if l2 is not None else 0
            digit = part1 + part2 + (1 if carry else 0)
            carry = False
            if digit >= 10:
                carry = True
                digit -= 10
            result.next = ListNode(digit)
            result = result.next
            l1 = l1.next if l1 is not None else None
            l2 = l2.next if l2 is not None else None
        if carry == True:
            result.next = ListNode(1)
        return resultcopy.next
            
                
            
        