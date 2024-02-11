/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var result = new ListNode(0)
        val copy = result
        var carry = false
        var l1copy = l1
        var l2copy = l2
        while (l1copy != null || l2copy != null) {
            val first = if (l1copy != null) l1copy.x else 0
            val second = if (l2copy != null) l2copy.x else 0
            var both = first + second
            if (carry) {
                both += 1
                carry = false
            }
            if (both >= 10) {
                carry = true
                both -= 10
            }
            result.next = new ListNode(both)
            result = result.next
            l1copy = if (l1copy != null) l1copy.next else null
            l2copy = if (l2copy != null) l2copy.next else null
        }
        if (carry) {
            result.next = new ListNode(1)
        }
        copy.next
    }
}