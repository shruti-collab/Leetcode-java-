/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    TreeNode root;
    ArrayList<Integer> tree;
    int i;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.tree = new ArrayList<>();
        Inorder(root, tree);
        for(int i : tree){
            System.out.print(i+" ");
        }
        this.i = 0;
    }
    
    public int next() {
        int val = tree.get(i);
        i++;
        return val;
    }
    
    public boolean hasNext() {
        if(i-1 == tree.size()-1){
            return false;
        }
        return true;
    }

    public void Inorder(TreeNode root, ArrayList<Integer> tree){
        if(root == null){
            return;
        }

        Inorder(root.left, tree);
        tree.add(root.val);
        Inorder(root.right, tree);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */