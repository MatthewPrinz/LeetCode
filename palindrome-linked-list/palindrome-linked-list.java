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
    public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverseList(slow);
    
    while (slow != null) {
        if (head.val != slow.val) {
            return false;
        }
        head = head.next;
        slow = slow.next;
    }
    return true;
}
    /*
    public boolean isPalindrome(ListNode head) {
        ListNode counter = head;
        ListNode end = null;
        int size = 0;
        while (counter != null) {
            end = counter;
            counter = counter.next;
            size++;
        }
        ListNode mid = head;
        for (int i = 0; i < size; i++)
            mid = mid.next;
        ListNode reversed = reverseList(mid);
        while (head != null) {
            if (reversed.val != head.val)
                return false;
            reversed = reversed.next;
            head = head.next;
        }
        return true;
      }
    */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
    
}