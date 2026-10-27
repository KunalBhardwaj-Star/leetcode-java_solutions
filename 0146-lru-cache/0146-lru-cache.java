class LRUCache {

    private class Node{
        int key , val;
        Node prev , next;

        Node(int k , int v){
            this.key = k;
            this.val = v;
        }
    }

    HashMap<Integer , Node> map;
    int capacity;
    Node head , tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = this.tail = new Node(-1 , -1);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertFirst(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node curr = map.get(key);

        remove(curr);
        insertFirst(curr);

        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;

            remove(node);
            insertFirst(node);

            return;
        }

        Node node = new Node(key , value);
        insertFirst(node);
        map.put(key , node);

        if(map.size() > capacity){
            Node lruTail = tail.prev;

            remove(lruTail);
            map.remove(lruTail.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */