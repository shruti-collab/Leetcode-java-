class Solution {
    public Node connect(Node root) {
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        helper(map,0, root);
        helperPlus(map);
        return root;
    }
    void helper(HashMap<Integer, ArrayList<Node>> map, int level, Node node){
        if(node == null){
            return;
        }
        if(map.containsKey(level)){
            map.get(level).add(node);
        }else{
            map.put(level,new ArrayList<Node>());
            map.get(level).add(node);
        }
        helper(map, level+1, node.left);
        helper(map,level+1, node.right);
    }
    void helperPlus(HashMap<Integer, ArrayList<Node>> map){
        for(int i: map.keySet()){
            ArrayList<Node> list = map.get(i);
            Node l = list.get(0);
            for(int j=1;j<list.size();j++){
                l.next = list.get(j);
                l = list.get(j);
            }
        }
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/