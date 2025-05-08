package leetCode.leetcode.editor.en;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and 
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 23740 👎 561


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;
        int result;
        boolean[][] visited;
        char[][] grid;

        Queue<Pair> q;

        public int numIslands(char[][] grid) {
            init(grid);
            Pair temp;
            for (int i = 0; i < this.m; i ++) {
                for (int ii = 0; ii < this.n; ++ii) {
                    if (!visited[i][ii] && grid[i][ii] == '1') { //not visited
                        temp = new Pair(i, ii);
                        q.add(temp);
                        visited[i][ii] = true;
                        updateIsland();
                        result++;
                    }
                }
            }
            return result;
        }

        private void updateIsland() {
            Pair temp;
            int y;
            int x;
            while (!q.isEmpty()) {
                temp = q.poll();
                y = temp.y;
                x = temp.x;

                if (0 <= y-1 && !visited[y-1][x] && grid[y-1][x] == '1') {
                    q.add(new Pair(y-1, x));
                    visited[y-1][x] = true;
                }

                if (y+1 < m && !visited[y+1][x] && grid[y+1][x] == '1') {
                    q.add(new Pair(y+1, x));
                    visited[y+1][x] = true;
                }

                if (0 <= x-1 && !visited[y][x-1] && grid[y][x-1] == '1') {
                    q.add(new Pair(y, x-1));
                    visited[y][x-1] = true;
                }

                if (x+1 < n && !visited[y][x+1] && grid[y][x+1] == '1') {
                    q.add(new Pair(y, x+1));
                    visited[y][x+1] = true;
                }
            }
        }

        private void init(char[][] grid) {
            m = grid.length;
            n = (m == 0) ? 0 : grid[0].length;
            this.grid = grid;
            visited = new boolean[m][n];
            q = new LinkedList<>();
            result = 0;
        }

        private static class Pair {
            public int y;
            public int x;

            public Pair(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}