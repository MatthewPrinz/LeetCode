class LRUCache {

    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> cache = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    void insert(Node node) {
        cache.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }
    void remove(Node node) {
        cache.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (capacity == cache.size()) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */