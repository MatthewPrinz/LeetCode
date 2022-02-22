/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> origToCopy = new HashMap<>();
        Node orig = head;
        while (orig != null) {
            origToCopy.put(orig, new Node(orig.val));
            orig = orig.next;
        }
        orig = head;
        while (orig != null) {
            origToCopy.get(orig).next = origToCopy.get(orig.next);
            origToCopy.get(orig).random = origToCopy.get(orig.random);
            orig = orig.next;
        }
        return origToCopy.get(head);
    }
    
}