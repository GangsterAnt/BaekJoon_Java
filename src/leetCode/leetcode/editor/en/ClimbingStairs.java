package leetCode.leetcode.editor.en;

//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics Math Dynamic Programming Memoization 👍 23085 👎 956


public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();

        System.out.println(solution.climbStairs(45));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] solution;

        public int climbStairs(int n) {
            initDp();
            return solution[n];
        }

        private void initDp() {
            solution = new int[46];
            solution[1] = 1;
            solution[2] = 2;
            solution[3] = 3;

            for (int i = 4; i < 46; ++i) {
                solution[i] = solution[i - 1] + solution[i - 2];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}