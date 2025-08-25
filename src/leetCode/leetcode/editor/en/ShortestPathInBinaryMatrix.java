package leetCode.leetcode.editor.en;

//Given an n x n binary matrix grid, return the length of the shortest clear 
//path in the matrix. If there is no clear path, return -1. 
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0
//)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 
//
// 
// All the visited cells of the path are 0. 
// All the adjacent cells of the path are 8-directionally connected (i.e., they 
//are different and they share an edge or a corner). 
// 
//
// The length of a clear path is the number of visited cells of this path. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,1],[1,0]]
//Output: 2
// 
//
// Example 2: 
// 
// 
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
//
// Related Topics Array Breadth-First Search Matrix 👍 7134 👎 268


import java.util.Deque;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();

        solution.shortestPathBinaryMatrix(new int[][] {{0,1}, {1,0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;

            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
                return -1;
            }

            boolean[][] visited = new boolean[n][n];
            int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

            Deque<Pair> q = new LinkedList<>();
            q.add(new Pair(0, 0, 1));
            visited[0][0] = true;

            Pair current;
            int tempY, tempX;
            while (!q.isEmpty()) {
                current = q.pollFirst();

                if (current.y == n - 1 && current.x == n - 1) {
                    return current.dist;
                }

                for (int i = 0; i < 8; i++) {
                    tempY = current.y + directions[i][0];
                    tempX = current.x + directions[i][1];

                    if (0 <= tempY && tempY < n && 0 <= tempX && tempX < n
                            && grid[tempY][tempX] == 0
                            && !visited[tempY][tempX]) {
                        visited[tempY][tempX] = true;
                        q.add(new Pair(tempY, tempX, current.dist + 1));
                    }
                }
            }

            return -1;
        }

        private static class Pair {
            public int y;
            public int x;
            public int dist;

            Pair(int y, int x, int dist) {
                this.y = y;
                this.x = x;
                this.dist = dist;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}