import java.util.*;

class Solution {
    // Memoization table to cache results for each 'n'
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        // Full binary trees cannot have an even number of nodes
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        // Base case: single node
        if (n == 1) {
            List<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }

        // Return cached result if already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        // Distribute remaining n - 1 nodes between left and right subtrees
        for (int i = 1; i < n; i += 2) {
            int leftNodes = i;
            int rightNodes = n - 1 - i;

            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNodes);

            // Combine each left subtree with each right subtree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}