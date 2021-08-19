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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null)
        {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
        
        
        // ListNode newList = null;
        // while (head != null)
        // {
        //     ListNode listNode = head;
        //     head = head.next;
        //     listNode.next = newList;
        //     newList = listNode;
        // }
        // return newList;
        
        // ArrayList<Integer> nodes = new ArrayList<>();
        // ListNode tempNode = head;
        // ListNode result = head;
        // while (tempNode != null)
        // {
        //     nodes.add(tempNode.val);
        //     tempNode = tempNode.next;
        // }
        // Collections.reverse(nodes);
        // for (int i = 0; i < nodes.size(); i++)
        // {
        //     head.val = nodes.get(i);
        //     head = head.next;
        // }
        // return result;
    }
}