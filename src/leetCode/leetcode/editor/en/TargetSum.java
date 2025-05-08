package leetCode.leetcode.editor.en;

//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which 
//evaluates to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be 
//target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics Array Dynamic Programming Backtracking 👍 11763 👎 390


import java.util.HashSet;
import java.util.Set;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        solution.findTargetSumWays(new int[]{1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] nums;
        private int target;
        private boolean[] plusList;
        private int length;
        private int result;

        private Set<Integer> visitedSet;

        public int findTargetSumWays(int[] nums, int target) {
            init(nums, target);
            dfs(0);
//            System.out.println(result);
            return result;
        }

        private void dfs(int current) {
            if (current == length) {
                int cal = doCal();
                if (cal == target) {
                    int visitedInt = convertToSet(this.plusList);
                    if (!this.visitedSet.contains(visitedInt)) {
                        this.visitedSet.add(visitedInt);
//                        debug();
                        result++;
                    } else  {
                        return;
                    }
                }
                return;
            }

            for (int i = current; i < length; ++i) {
                // for Plus
                plusList[i] = true;
                dfs(current + 1);

                //for Minus
                plusList[i] = false;
                dfs(current + 1);
            }

        }

        private void debug() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; ++i) {
                if (plusList[i]) {
                    sb.append("+");
                } else {
                    sb.append("-");
                }

                sb.append(nums[i]);
            }

            System.out.println(sb);
        }

        private int doCal() {
            int tempResult = 0;
            for (int i = 0; i < length; ++i) {
                if (plusList[i]) {
                    tempResult += nums[i];
                } else {
                    tempResult -= nums[i];
                }
            }

            return tempResult;
        }

        private int convertToSet(boolean[] plusList) {
            int res = 0;
            for (int i = 0; i < length; ++i) {
                res *= 10;
                if (plusList[i]) {
                    res += 1;
                }
            }
            return res;
        }

        private void init(int[] nums, int target) {
            this.length = nums.length;
            this.target = target;
            this.nums = nums;
            this.plusList = new boolean[length];
            this.result = 0;
            visitedSet = new HashSet<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}