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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head;
        if (l1.val > l2.val)
        {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        else
        {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode result = head;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null)
        {
            head.next = new ListNode(l1.val);
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null)
        {
            head.next = new ListNode(l2.val);
            head = head.next;
            l2 = l2.next;
        }
        return result;
    }
}