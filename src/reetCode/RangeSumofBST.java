package reetCode;

public class RangeSumofBST {

    public static int static_low;
    public static int static_high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        static_low = low;
        static_high = high;
        return recursive(root);
    }

    private int recursive(TreeNode node) {
        int result = 0;
        if (node.val >= static_low && node.val <= static_high) {
            result += node.val;
        }

        if (node.left != null && node.val > static_low) {
            result +=recursive(node.left);
        }

        if (node.right != null && node.val < static_high) {
            result += recursive(node.right);
        }

        return result;
    }

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
