package leetCode.leetcode.editor.en;

//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics Array Sorting 👍 23768 👎 872


import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            List<Interval> givenList = new ArrayList<>();
            List<Interval> ansList = new ArrayList<>();

            for (int[] interval : intervals) {
                givenList.add(new Interval(interval[0], interval[1]));
            }

            Collections.sort(givenList);
            Set<Interval> visited = new HashSet<>();
            Interval a, b;
            int s, e;
            for (int i = 0; i < n; ++i) {
                a = givenList.get(i);
                if (visited.contains(a)) {
                    continue;
                }
                visited.add(a);
                s = a.start;
                e = a.end;
                for (int ii = i + 1; ii < n; ++ii) {
                    b = givenList.get(ii);
                    if (s <= b.start && b.start <= e) {
                        e = Math.max(e, b.end);
                        visited.add(b);
                    }
                }
                ansList.add(new Interval(s, e));
            }

            int size = ansList.size();
            int[][] ansArr = new int[size][2];
            for (int i = 0; i < size; ++i) {
                ansArr[i] = ansList.get(i).toArr();
            }
            return ansArr;
        }

        public int[][] merge2(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> ans = new ArrayList<>();
            int[] current = intervals[0];

            for (int i = 0; i < intervals.length; ++i) {
                if (current[1] <= intervals[i][0]) {
                    current[1] = Math.max(current[1], intervals[i][1]);
                } else {
                    ans.add(current);
                    current = intervals[i];
                }
            }
            //마지막 원소는 무조건 머지가 될수 없다. 수동 추가
            ans.add(current);

            return ans.toArray(new int[ans.size()][2]);
        }


        public static class Interval implements Comparable<Interval> {
            int start;
            int end;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public int[] toArr() {
                return new int[]{start, end};
            }

            @Override
            public int compareTo(Interval o) {
                if (this.start != o.start) {
                    return this.start - o.start;
                }
                return this.end - o.end;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}