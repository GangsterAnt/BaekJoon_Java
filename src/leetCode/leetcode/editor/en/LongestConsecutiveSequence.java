package leetCode.leetcode.editor.en;

//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// Example 3: 
//
// 
//Input: nums = [1,0,1,2]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array Hash Table Union Find 👍 21985 👎 1190

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();

        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); //4
        System.out.println(solution.longestConsecutive(new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7})); //4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //빠르나 메모리를 많이먹음 set 최적화 하지않지만 2번쨰 loop를 set으로 돎
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int maxLength = 0;

            for (int num : nums) {
                set.add(num);
            }

            int tempLength = 1;
            for (int num : set) {
                tempLength = 1;
                if (!set.contains(num - 1)) {
                    while (set.contains(num + tempLength)) {
                        tempLength++;
                    }
                }
                maxLength = Math.max(tempLength, maxLength);
            }

            return maxLength;
        }

        //느리나 메모리가 적게 먹음. set 최적화함
        public int longestConsecutive2(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int maxLength = 0;

            for (int num : nums) {
                set.add(num);
            }

            int tempLength = 1;
            for (int num : nums) {
                tempLength = 1;
                set.remove(num);
                if (!set.contains(num - 1)) {
                    while (set.contains(num + tempLength)) {
                        set.remove(num + tempLength);
                        tempLength++;
                    }
                }
                maxLength = Math.max(tempLength, maxLength);
            }

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /*

     */

}