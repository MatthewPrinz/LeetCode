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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odds = new ListNode(head.val);
        ListNode result = odds;
        ListNode evens = new ListNode(0);
        ListNode save = null;
        int i = 0;
        while (head != null) {
            if (i % 2 == 1 && head.next != null) {
                odds.next = head.next;
                odds = odds.next;
            }
            else {
                evens.next = head.next;
                evens = evens.next;
                if (i == 0)
                    save = evens;
            }
            i++;
            head = head.next;
        }
        odds.next = save;
        return result;
    }
}