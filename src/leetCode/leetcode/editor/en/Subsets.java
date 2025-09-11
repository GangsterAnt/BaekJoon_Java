package leetCode.leetcode.editor.en;

//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
//
// Related Topics Array Backtracking Bit Manipulation 👍 18598 👎 323


import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> ans;
        int length;
        boolean[] visited;
        int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        //init

         ans = new ArrayList<>();
        length = nums.length;
        visited = new boolean[length];
        this.nums = nums;

        //init done

        for (int i = 0; i <= length; ++i) {
            dfs(i,0,0,  new ArrayList<>());
        }

        return ans;
    }

    private void dfs(int targetDepth, int currentDepth, int index, List<Integer> tempAns) {
        if (targetDepth == currentDepth) {
            ans.add(new ArrayList<>(tempAns));
        }
        for (int i = index; i < this.length; ++i) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tempAns.add(nums[i]);
            dfs(targetDepth, currentDepth + 1,i,  tempAns);
            visited[i] =false;
            tempAns.remove(tempAns.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}