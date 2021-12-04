class LRUCache {

    private class ListNode {
        ListNode next;
        ListNode prev;
        int val;
        int key;

        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    Map<Integer, ListNode> cache = new HashMap<>();
    int capacity;
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    private void remove(ListNode node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(ListNode node) {
        cache.put(node.key, node);
        ListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
    
    
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.prev);
        }
        insert(new ListNode(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */