package leetCode.leetcode.editor.en;

//Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 16253 👎 349


import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> answer = new ArrayList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.add(root);
            List<TreeNode> list;

            while (!q.isEmpty()) {
                list = new ArrayList<>();
                while (!q.isEmpty()) {
                    list.add(q.poll());
                }
                List<Integer> tempAnswer = new ArrayList<>();
                for (TreeNode node : list) {
                    tempAnswer.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                answer.add(tempAnswer);
            }
//            while (!q.isEmpty()) {
//                int size = q.size();
//                List<Integer> level = new ArrayList<>(); //TreeNode list가 아니라 IntegerList로 바로 선언
//
//                for (int i = 0; i < size; i++) {
//                    TreeNode node = q.poll();
//                    level.add(node.val);
//                    if (node.left != null) q.add(node.left);
//                    if (node.right != null) q.add(node.right);
//                }
//
//                answer.add(level);
//            }
            return answer;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
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