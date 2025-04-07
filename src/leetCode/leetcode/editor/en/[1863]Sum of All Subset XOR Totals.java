package leetCode.leetcode.editor.en;//The XOR total of an array is defined as the bitwise XOR of all its elements,
//or 0 if the array is empty. 
//
// 
// For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1. 
// 
//
// Given an array nums, return the sum of all XOR totals for every subset of 
//nums. 
//
// Note: Subsets with the same elements should be counted multiple times. 
//
// An array a is a subset of an array b if a can be obtained from b by deleting 
//some (possibly zero) elements of b. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3]
//Output: 6
//Explanation: The 4 subsets of [1,3] are:
//- The empty subset has an XOR total of 0.
//- [1] has an XOR total of 1.
//- [3] has an XOR total of 3.
//- [1,3] has an XOR total of 1 XOR 3 = 2.
//0 + 1 + 3 + 2 = 6
// 
//
// Example 2: 
//
// 
//Input: nums = [5,1,6]
//Output: 28
//Explanation: The 8 subsets of [5,1,6] are:
//- The empty subset has an XOR total of 0.
//- [5] has an XOR total of 5.
//- [1] has an XOR total of 1.
//- [6] has an XOR total of 6.
//- [5,1] has an XOR total of 5 XOR 1 = 4.
//- [5,6] has an XOR total of 5 XOR 6 = 3.
//- [1,6] has an XOR total of 1 XOR 6 = 7.
//- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
//0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
// 
//
// Example 3: 
//
// 
//Input: nums = [3,4,5,6,7,8]
//Output: 480
//Explanation: The sum of all XOR totals for every subset is 480.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 12 
// 1 <= nums[i] <= 20 
// 
//
// Related Topics Array Math Backtracking Bit Manipulation Combinatorics 
//Enumeration 👍 2410 👎 299


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int staticResult = 0;
    boolean[] staticVisited;
    int[] staticNums;
    int staticIndex = 0;
    int staticLength = 0;

    public int subsetXORSum(int[] nums) {

        staticResult = 0;
        staticLength = nums.length;
        staticVisited = new boolean[staticLength];
        staticNums = nums;
        staticIndex = 0;

        if (staticLength == 0) {
            return 0;
        }

        for (int i = 0; i <= staticLength; i++) {
            dfs(i, 0, 0);
        }
        return staticResult;
    }

    public int dfs(int targetSubsetLength, int currentSelectedItems, int startIndex) {
        if (targetSubsetLength == currentSelectedItems) {
            staticResult += calXor();
            System.out.println("staticResult = " + calXor());
        }

        for (int i = startIndex; i < staticLength; ++i) {
            if (!staticVisited[i]) {
                staticVisited[i] = true;
                dfs(targetSubsetLength, currentSelectedItems + 1, i + 1);
                staticVisited[i] = false;
            }
        }

        return 0;
    }

    public int calXor() {
        int localResult = 0;

        for (int i = 0; i < staticNums.length; i++) {
            if (staticVisited[i]) {
                localResult ^= staticNums[i];
            }
        }
        return localResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
