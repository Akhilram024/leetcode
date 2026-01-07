class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        dfs(root);
        return (int)(maxProduct % MOD);
    }

    private long getSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;

        long left = dfs(node.left);
        long right = dfs(node.right);

        long subSum = node.val + left + right;
        maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));

        return subSum;
    }
}
