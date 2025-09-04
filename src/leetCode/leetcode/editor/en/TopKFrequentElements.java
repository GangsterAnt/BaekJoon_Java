package leetCode.leetcode.editor.en;

//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,1,2,2,3], k = 2 
// 
//
// Output: [1,2] 
//
// Example 2: 
//
// 
// Input: nums = [1], k = 1 
// 
//
// Output: [1] 
//
// Example 3: 
//
// 
// Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2 
// 
//
// Output: [-1] 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 18639 👎 795


import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public static final Comparator<Map.Entry<Integer, Integer>> FREQUENCY_SORT =
                (a, b) -> b.getValue().compareTo(a.getValue());

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        // key-value 쌍을 빈도 기준으로 내림차순 정렬
        List<Map.Entry<Integer, Integer>> sorted = map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = sorted.get(i).getKey(); // 숫자(key)만 뽑기
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}