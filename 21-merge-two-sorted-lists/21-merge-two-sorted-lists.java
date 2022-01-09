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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode result = new ListNode(0);
        ListNode copy = result;
        while (list1 != null || list2 != null) {
            ListNode next = new ListNode();
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    next.val = list1.val;
                    list1 = list1.next;
                } else {
                    next.val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 != null && list2 == null) {
                next.val = list1.val;
                list1 = list1.next;
            } else if (list2 != null && list1 == null) {
                next.val = list2.val;
                list2 = list2.next;
            }
            result.next = next;
            result = result.next;
        }
        return copy.next;
    }
}