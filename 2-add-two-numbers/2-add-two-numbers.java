/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootResult = new ListNode();
        ListNode returnCopy = rootResult;
        boolean carry = false;
        while (l1 != null || l2 != null)
        {
            int build1 = l1 == null ? 0 : l1.val;
            int build2 = l2 == null ? 0 : l2.val;
            int result = carry ? build1 + build2 + 1: build1 + build2;
            if (result >= 10)
            {
                carry = true;
                result -= 10;
            }
            else
            {
                carry = false;
            }
            if (rootResult != null)
                rootResult.val = result;
            if  ( (l1 != null && l1.next != null) || (l2 != null && l2.next != null) )
            {
                rootResult.next = new ListNode();
            }
            if (rootResult.next != null)
                rootResult = rootResult.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry)
            rootResult.next = new ListNode(1);
        return returnCopy;
        
    }
}