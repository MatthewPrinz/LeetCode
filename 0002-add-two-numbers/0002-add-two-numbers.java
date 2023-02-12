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
        boolean carry = false;
        ListNode result = new ListNode(0);
        ListNode copy = result;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + 
                (carry ? 1 : 0);
            if (sum >= 10) {
                sum -= 10;
                carry = true;
            } else {
                carry = false;
            }
            result.next = new ListNode(sum);
            result = result.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry) {
            result.next = new ListNode(1);
        }
        return copy.next;
    }
}