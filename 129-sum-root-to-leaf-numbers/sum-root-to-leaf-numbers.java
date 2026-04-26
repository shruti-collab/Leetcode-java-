class Solution {
    int ans = 0;

    public void getSum(TreeNode root, int n) {
        if (root == null) return;
        n = n * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += n;
            return;
        }
        getSum(root.left, n);
        getSum(root.right, n);
    }

    public int sumNumbers(TreeNode root) {
        getSum(root, 0);
        return ans;
    }
}