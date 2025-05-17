package leetCode.leetcode.editor.en;

//You are a professional robber planning to rob houses along a street. Each 
//house has a certain amount of money stashed, the only constraint stopping you from 
//robbing each of them is that adjacent houses have security systems connected and 
//it will automatically contact the police if two adjacent houses were broken 
//into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, 
//return the maximum amount of money you can rob tonight without alerting the 
//police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics Array Dynamic Programming 👍 22169 👎 470


public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
        System.out.println(solution.rob(new int[]{2,1,1,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] maxScore;
        int length;

        public int rob(int[] nums) {
            if (nums.length == 0 ) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

//            init(nums);
//            return Integer.max(maxScore[length - 1], maxScore[length - 2]);
            return init2(nums);
        }

        private void init(int[] nums) {
            this.length = nums.length;
            this.maxScore = new int[length];
            maxScore[0] = nums[0];
            maxScore[1] = nums[1];

            if (length == 2) {
                return;
            }
            int tempMax;

            maxScore[2] = Integer.max(maxScore[1], maxScore[0] + nums[2]);

            for (int i = 3; i < length; ++i) {
                tempMax = Integer.max(maxScore[i - 2] + nums[i], maxScore[i - 3] + nums[i]);
                maxScore[i] = Integer.max(tempMax, maxScore[i - 1]);
            }
        }

        private int init2(int[] nums) {
            this.length = nums.length;
            if (length == 0) return 0;
            if (length == 1) return nums[0];

            int prev2 = nums[0];
            int prev1 = Math.max(nums[0], nums[1]);

            for (int i = 2; i < length; i++) {
                int curr = Math.max(prev1, prev2 + nums[i]);
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}