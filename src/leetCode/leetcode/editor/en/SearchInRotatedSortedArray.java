package leetCode.leetcode.editor.en;

//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly left rotated at an 
//unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k],
// nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// 
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 28718 👎 1734


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();

        System.out.println(solution.searchGPT(new int[]{1}, 1));
        System.out.println(solution.searchGPT(new int[]{1, 3}, 2));
        System.out.println(solution.searchGPT(new int[]{3, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int searchGPT(int[] nums, int target) {
            int start, mid, end;
            start = 0;
            end = nums.length - 1;
            while (start <= end) {
                mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[start] <= nums[mid]) { //L sorted
                    if (nums[start] <= target && target < nums[mid]) { // in left
                        end = mid - 1;
                        continue;
                    } else {  //in right
                        start = mid + 1;
                        continue;
                    }
                } else { // r sorted
                    if (nums[mid] < target && target <= nums[end]) { // in r
                        start = mid + 1;
                        continue;
                    } else {  //in left
                        end = mid - 1;
                        continue;
                    }
                }
            }

            return -1;
        }

        public int search(int[] nums, int target) {
            int start, mid, end;
            start = 0;
            end = nums.length - 1;
            mid = (nums.length - 1) / 2;

            if (nums[start] == target) {
                return start;
            }

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[end] == target) {
                return end;
            }

            while (mid != end && start != mid && end != start) {
                if (nums[start] == target) {
                    return start;
                }

                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[end] == target) {
                    return end;
                }
                if (nums[start] < nums[mid]) { //L sorted
                    if (nums[start] < target && target < nums[mid]) { // in left
                        end = mid;
                        mid = (start + end) / 2;
                        continue;
                    } else {  //in right
                        start = mid;
                        mid = (start + end) / 2;
                        continue;
                    }
                } else { // r sorted
                    if (nums[mid] < target && target < nums[end]) { // in r
                        start = mid;
                        mid = (start + end) / 2;
                        continue;
                    } else {  //in left
                        end = mid;
                        mid = (start + end) / 2;
                        continue;
                    }
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}