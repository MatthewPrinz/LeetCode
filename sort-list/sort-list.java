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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, middle = head;
        while (fast.next != null && fast.next.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(middleNext);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode result;
        if (left == null)
            return right;
        else if (right == null)
            return left;
        if (left.val < right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
}