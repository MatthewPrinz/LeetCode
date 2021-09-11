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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Map<ListNode, Integer> map = new HashMap<>();
        while (slow != null) {
            map.put(slow, map.getOrDefault(slow, 0) + 1);
            if (map.get(slow) >= 2)
                return slow;
            slow = slow.next;
        }
        return null;
        
    }
}