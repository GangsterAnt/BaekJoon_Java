package leetCode.leetcode.editor.en;

//Given an integer array nums, return true if you can partition the array into 
//two subsets such that the sum of the elements in both subsets is equal or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics Array Dynamic Programming 👍 13119 👎 278


public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{3, 6, 8, 1, 1, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /*

    합이 같은 2개의 부분집합을 구한다는것은..
    P (부분집합의 합), N (여잡합의 합)이라하자
    P = N -> P - N = 0
    P + N = totalSum <- 이는 자명하다
    고로 2P = totalSum -> P = totalSum/2 를 찾는 문제이다 :(
     */
    class Solution {
        private boolean[] dp;
        private int length;
        private int target;

        public boolean canPartition(int[] nums) {
            boolean possible = init(nums);
            if (!possible) {
                return false;
            }

            dp[0] = true;
            for (int i = 0; i < length; ++i) {
                if (dp[target]) {
                    return true;
                }
                //update
                //거꾸로 연산한다.
                //왜냐면 내가 업데이트 한값이 다음 연산에 반영됨
                //즉 앞에서 부터 연산하면 1이 들어왔을떄 dp[1] = true -> dp[2] = dp[2 -1] = true 이사단이 난다.
                for (int ii = target; ii >= nums[i]; --ii) {
                    if (dp[ii - nums[i]] || nums[i] == ii) {
                        dp[ii] = true;
                    }
                }
            }
            return dp[target];
        }

        private boolean init(int[] nums) {
            this.length = nums.length;
            int ret = 0;
            for (int i = 0; i < nums.length; ++i) {
                ret += nums[i];
            }

            if (ret % 2 != 0) { // totalSum이 홀수면, 불가능
                return false;
            }
            this.target = ret / 2;
            dp = new boolean[target + 1];
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}