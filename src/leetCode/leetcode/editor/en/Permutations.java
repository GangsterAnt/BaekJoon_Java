package leetCode.leetcode.editor.en;

//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// Related Topics Array Backtracking 👍 19881 👎 355


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();

        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        System.out.println(permute);

        permute = solution.permute(new int[]{0, 1});
        System.out.println(permute);

        permute = solution.permute(new int[]{1});
        System.out.println(permute);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] nums;
        boolean[] visited;
        int length;

        List<List<Integer>> result;

        public List<List<Integer>> permute(int[] nums) {
            init(nums);
            dfs(new ArrayList<>(), 0);
            return result;
        }

        private void dfs(List<Integer> temp, int currentDepth) {
            if (length == currentDepth) {
                result.add(new ArrayList<>(temp)); //deep copy
            }

            for (int i = 0; i < length; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp.add(nums[i]);
                    dfs(temp, currentDepth + 1);
                    visited[i] = false;
                    temp.remove(temp.size() -1);
                }
            }
        }

        private void init(int[] nums) {
            this.nums = nums;
            this.length = nums.length;
            this.visited = new boolean[length];
            this.result = new ArrayList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}