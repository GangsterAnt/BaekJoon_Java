package leetCode.leetcode.editor.en;

//Given a 1-indexed array of integers numbers that is already sorted in non-
//decreasing order, find two numbers such that they add up to a specific target 
//number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1
// < index2 <= numbers.length. 
//
// Return the indices of the two numbers, index1 and index2, added by one as an 
//integer array [index1, index2] of length 2. 
//
// The tests are generated such that there is exactly one solution. You may not 
//use the same element twice. 
//
// Your solution must use only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We 
//return [1, 2].
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We 
//return [1, 3].
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We 
//return [1, 2].
// 
//
// 
// Constraints: 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers is sorted in non-decreasing order. 
// -1000 <= target <= 1000 
// The tests are generated such that there is exactly one solution. 
// 
//
// Related Topics Array Two Pointers Binary Search 👍 12488 👎 1469


// 1.TwoSum 으로도 풀리긴함. 인덱스 설정만 조금 만져주면
//그치만 정렬되어있으니 sliding window로도 풀어보자.
public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] ret1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ret2 = solution.twoSum(new int[]{2,3,4}, 6);
        int[] ret3 = solution.twoSum(new int[]{-1,0}, -1);

        System.out.println("done");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int l;
        int r;
        int length;

        public int[] twoSum(int[] numbers, int target) {
            init(numbers);

            int temp;
            while (true) {
                temp = numbers[l] + numbers[r];
                if (temp == target) {
                    return new int[]{l + 1, r + 1};
                } else if (temp < target) {
                    l++;
                } else if (temp > target) {
                    r--;
                }
            }
        }

        private void init(int[] numbers) {
            l = 0;
            length = numbers.length;
            r = length - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}