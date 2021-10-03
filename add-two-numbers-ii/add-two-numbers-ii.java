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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int length1 = 0, length2 = 0;
        ListNode copy1 = l1;
        ListNode copy2 = l2;
        while (copy1 != null) {
            stack1.push(copy1.val);
            copy1 = copy1.next;
            length1++;
        }
        while (copy2 != null) {
            stack2.push(copy2.val);
            copy2 = copy2.next;
            length2++;
        }
        if (length2 > length1)
            return addTwoNumbers(l2, l1);
        boolean carry = false;
        ListNode copy = new ListNode(-1);
        ListNode head = copy;
        while (!stack2.isEmpty()) {
            int digit = carry ? stack1.pop() + stack2.pop() + 1 : stack1.pop() + stack2.pop();
            carry = false;
            if (digit >= 10) {
                carry = true;
                digit -= 10;
            }
            ListNode digitNode = new ListNode(digit);
            copy.next = digitNode;
            copy = digitNode;
        }
        while (!stack1.isEmpty()) {
            int digit = carry ? stack1.pop() + 1 : stack1.pop();
            carry = false;
            if (digit >= 10) {
                carry = true;
                digit -= 10;
            }
            ListNode digitNode = new ListNode(digit);
            copy.next = digitNode;
            copy = digitNode;
        }
        if (carry) {
            copy.next = new ListNode(1); 
        }
        return reverse(head.next);   
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}