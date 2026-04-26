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
class Solution {
    int preIndex;
    HashMap<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();
        int n = preorder.length;

        // store inorder indices for fast lookup
        for(int i = 0 ; i <  inorder.length ;i++){
            map.put(inorder[i], i);
        }

        return helper(preorder,0,n-1);    
    }

    private TreeNode helper(int[] preOrder , int left , int right){
        if(left > right) return null;

        // pick root from preorder
        int rootValue = preOrder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // find root in inorder
        int mid = map.get(rootValue);

        // build left and right subtree
        root.left = helper(preOrder,left,mid-1);
        root.right = helper(preOrder , mid+1 ,right);

        return root;
    }
}