class LRUCache {

    class Node{
        int key,value;
        Node prev,next;

        Node(){

        }

        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    Map<Integer,Node> keyVsNode;
    Node head,tail;

    int capacity;
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev=head;
        keyVsNode = new HashMap();

        this.capacity = capacity;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev=node.prev;
    }

    public void insert(Node node){
        tail.prev.next = node;
        node.prev=tail.prev;
        tail.prev=node;
        node.next=tail;
    }
    
    public int get(int key) {
        Node node =  keyVsNode.get(key);
        if(node == null){
            return -1;
        }
        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {

        Node node = keyVsNode.get(key);

        if(node != null){
            remove(node);
            node.value=value;
            insert(node);
            return;
        }

        if(keyVsNode.size() == capacity){
            keyVsNode.remove(head.next.key);
            remove(head.next);
        }
        node =  new Node(key,value);
        insert(node);
        keyVsNode.put(key,node);
    }
}
