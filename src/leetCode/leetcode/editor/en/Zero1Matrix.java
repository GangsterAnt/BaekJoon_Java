package leetCode.leetcode.editor.en;

//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two cells sharing a common edge is 1. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
//
// 
// Note: This question is the same as 1765: https://leetcode.com/problems/map-
//of-highest-peak/ 
//
// Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 10359
// 👎 440


import java.util.*;

public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();

        solution.updateMatrix(new int[][] {{0,0,0}, {0,1,0}, {0,0,0}});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int m;
        int n;
        int[][] mat;
        int[][] ans;

        Deque<int[]> q;

        final int[][] lrud = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        init(mat);

        //순회하며 0 인 좌표들을 큐에 넣는다.
        for (int i = 0; i < m; ++i) {
            for (int ii = 0; ii < n; ++ii) {
                if (mat[i][ii] == 0) {
                    ans[i][ii] = 0;
                    q.add(new int[]{i, ii});
                }
            }
        }
        int y, x;
        int [] current;
        while (!q.isEmpty()) {
            //상하좌우 탐색
            current = q.pop();

            for (int i = 0; i < 4; ++i) {
               y = current[0] + lrud[i][0];
               x = current[1] + lrud[i][1];

               if (0 <= x && x < this.n &&  0 <= y && y < this.m && this.ans[y][x] == -1) {
                   ans[y][x] = ans[current[0]][current[1]] + 1;
                   q.add(new int[] {y,x});
               }
            }
        }

        return this.ans;
    }

    private void init(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
        this.ans = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int ii = 0; ii < n; ++ii) {
                ans[i][ii] = -1;
            }
        }

        this.q = new LinkedList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}