package leetCode.leetcode.editor.en;

//You are given an m x n binary matrix grid. An island is a group of 1's (
//representing land) connected 4-directionally (horizontal or vertical.) You may assume 
//all four edges of the grid are surrounded by water. 
//
// The area of an island is the number of cells with a value 1 in the island. 
//
// Return the maximum area of an island in grid. If there is no island, return 0
//. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,
//0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,
//0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]
//]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-
//directionally.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,0,0,0,0,0,0,0]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 10278 👎 214


import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int m;
        int n;
        boolean[][] visited;
        int[][] grid;

        int result;
        Queue<int[]> q;

        private static final int[] dy = new int[]{0, 1, 0, -1}; // right, up, left, down
        private static final int[] dx = new int[]{1, 0, -1, 0}; // right, up, left, down

        public int maxAreaOfIsland(int[][] grid) {
            init(grid);
            for (int i = 0; i < m; i++) {
                for (int ii = 0; ii < n; ii++) {
                    if (grid[i][ii] == 1 && !visited[i][ii]) {
                        visited[i][ii] = true;
                        q.add(new int[]{i, ii});
                        updateIsland();
                    }
                }
            }
            return result;
        }

        private void updateIsland() {
            int[] yx;
            int y;
            int x;
            int islandArea = 0;
            while (!q.isEmpty()) {
                yx = q.poll();
                islandArea++;
                for (int i=0; i<4; i++) {
                    y = yx[0] + dy[i];
                    x = yx[1] + dx[i];
                    if (0 <= y && 0 <= x && y < m && x <n && !visited[y][x] && grid[y][x] == 1) {
                        q.add(new int[]{y,x});
                        visited[y][x] = true;
                    }
                }
            }

            result = Math.max(result, islandArea);
        }

        private void init(int[][] grid) {
            this.m = grid.length;
            this.n = (m == 0) ? 0 : grid[0].length;
            visited = new boolean[m][n];
            this.grid = grid;
            this.q = new LinkedList<>();
            this.result = 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}