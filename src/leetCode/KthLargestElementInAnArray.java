package leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=problem-list-v2&envId=avihny73
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

    }
}

class Solution3 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i =0; i< nums.length; ++i) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.poll();
    }
}

class Solution2 {
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) { // 배열의 요소가 하나만 남으면 그 값을 반환
            return nums[left];
        }

        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1); // 피벗 선택
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k == pivotIndex) { // 피벗이 k번째로 큰 값일 때 반환
            return nums[k];
        } else if (k < pivotIndex) { // k번째 값이 피벗의 왼쪽에 있을 때
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else { // k번째 값이 피벗의 오른쪽에 있을 때
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right); // 피벗을 오른쪽으로 이동
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) { // 피벗보다 작은 값을 왼쪽으로 이동
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right); // 피벗을 최종 위치로 이동
        return storeIndex;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
