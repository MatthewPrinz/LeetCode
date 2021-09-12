/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null)
        {
            ListNode hb = headB;
            while (hb != null)
            {
                if (hb == headA)
                    return hb;
                hb = hb.next;
            }
            headA = headA.next;
        }
        return null;
    }
}