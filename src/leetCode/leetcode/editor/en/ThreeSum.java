package leetCode.leetcode.editor.en;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 33857 👎 3162


import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();

        printOut(solution.threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));
        //[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
        printOut(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
        //[-1,-1,2],[-1,0,1]]
    }

    public static void printOut(List<List<Integer>> ans) {
        StringJoiner sj = new StringJoiner(",");
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : ans) {
            sb.append("[");
            for (Integer i : list) {
                sb.append(i);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() -1);
            sb.append("]");
            sj.add(sb.toString());
            sb = new StringBuilder();
        }

        System.out.println(sj);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> ans = new HashSet<>();

            Arrays.sort(nums);
            int target,l,r;
            for (int i =0; i < nums.length-2; ++i) {
                r = nums.length -1;
                l = i +1;
                target = nums[i] * -1;

                while(l < r) {
                    if (nums[l] + nums[r] == target) {
                        ans.add(List.of(nums[i], nums[l], nums[r]));
                        l++;
                        r--;

                    } else if (nums[l] + nums[r] < target) {
                        l++;
                    } else if (nums[l] + nums[r] > target) {
                        r--;
                    }
                }
            }

            return ans.stream().toList();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}