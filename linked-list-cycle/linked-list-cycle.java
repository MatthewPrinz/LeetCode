/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        // Improve clarity
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
        /*
        while (fast != null && slow != null) {
            if (fast == slow)
                return true;
            if (fast.next != null)
                fast = fast.next.next;
            else 
                return false;
            slow = slow.next;
        }
        return false;
        */
    }
}