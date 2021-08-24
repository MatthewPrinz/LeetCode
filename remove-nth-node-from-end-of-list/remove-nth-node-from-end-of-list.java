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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        if (head == null || head.next == null)
            return null;
        ListNode copy = head;
        while (copy != null) {
            copy = copy.next;
            length++;
        }
        ListNode toRemove = head;
        if (n == 1) {
            while (toRemove.next.next != null) {
                toRemove = toRemove.next;
            }
            toRemove.next = null;
            return head;
        }
        int removeNode = length - n;
        for (int i = 0; i < removeNode; i++) {
            toRemove = toRemove.next;
        }
        // Deleting from not the end
        toRemove.val = toRemove.next.val;
        toRemove.next = toRemove.next.next;
        return head;
    }
}