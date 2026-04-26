class LRUCache {

    class Node{
        int key,value;
        Node prev,next;

        public Node(int k,int v){
            key=k;
            value=v;
        }
    }

    private int capacity;
    private Map<Integer,Node> hm;
    private Node head,tail;


    public LRUCache(int capacity) {
        this.capacity=capacity;
        hm=new HashMap<>();

        head=new Node(-1,-1);
        tail=new Node(-1,-1);

        head.next=tail;
        tail.prev=head;
    }

    private void remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void insertToFront(Node node){
        Node headNext=head.next;
        head.next=node;
        node.next=headNext;
        node.prev=head;
        headNext.prev=node;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node cur=hm.get(key);
            remove(cur);
            insertToFront(cur);
            return cur.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node existing=hm.get(key);
            remove(existing);
            hm.remove(key,existing);
        }
        if(hm.size()==capacity){
            Node lru=tail.prev;

            remove(lru);
            hm.remove(lru.key);


        }

        Node newNode=new Node(key,value);
        insertToFront(newNode);
        hm.put(key,newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */