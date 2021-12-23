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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = head, prev = new ListNode(-101);
        boolean delete = false;
        while (head.next != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                delete = true;
            }
            if (delete) {
                prev.next = head.next;
                if (prev.val == -101) {
                    result = prev.next;
                }
                delete = false;
                head = prev;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return result;
    }
}