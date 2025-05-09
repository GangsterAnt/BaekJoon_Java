package leetCode.leetcode.editor.en;

//You are given an m x n matrix board containing letters 'X' and 'O', capture 
//regions that are surrounded: 
//
// 
// Connect: A cell is connected to adjacent cells horizontally or vertically. 
// Region: To form a region connect every 'O' cell. 
// Surround: The region is surrounded with 'X' cells if you can connect the 
//region with 'X' cells and none of the region cells are on the edge of the board. 
// 
//
// To capture a surrounded region, replace all 'O's with 'X's in-place within 
//the original board. You do not need to return anything. 
//
// 
// Example 1: 
//
// 
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]] 
// 
//
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]] 
//
// Explanation: 
// 
// In the above diagram, the bottom region is not captured because it is on the 
//edge of the board and cannot be surrounded. 
//
// Example 2: 
//
// 
// Input: board = [["X"]] 
// 
//
// Output: [["X"]] 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 9186 👎 2067


import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        /*
        Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
         */
        char[][] board = new char[4][4];
        board[0] = new char[]{'X','X','X','X'};
        board[1] = new char[]{'X','O','O','X'};
        board[2] = new char[]{'X','X','O','X'};
        board[3] = new char[]{'X','O','X','X'};

        solution.solve(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int m;
        int n;
        char[][] board;
        boolean[][] visited;
        boolean[][] edgeMap;

        Queue<int[]> q;
        Queue<int[]> island;

        int[] dy = new int[]{0, 1, 0, -1}; //Right Up Left Down
        int[] dx = new int[]{1, 0, -1, 0}; //Right Up Left Down

        public void solve(char[][] board) {
            init(board);
            for (int i = 0; i < m; i++) {
                for (int ii = 0; ii < n; ii++) {
                    if (board[i][ii] == 'O' && !visited[i][ii]) {
                        // init bfs
                        island = new LinkedList<>(); //init island for every start
                        q.add(new int[]{i, ii});
                        visited[i][ii] = true;
                        if (!bfs()) {
                            for (int[] island : island) {
                                board[island[0]][island[1]] = 'X';
                            }
                        }
                    }
                }
            }

        }

        private boolean bfs() {
            boolean isMeetEdge = false;
            int[] temp;
            while (!q.isEmpty()) {
                temp = q.poll();
                island.add(temp);
                int y;
                int x;
                for (int i = 0; i < 4; ++i) { //update near element
                    y = temp[0] + dy[i];
                    x = temp[1] + dx[i];

                    if ((0 <= y && y < m && 0 <= x && x < n) && board[y][x] == 'O' && !visited[y][x]) {
                     q.add(new int[]{y,x});
                     visited[y][x] = true;
                    } else if (!isMeetEdge && (y == -1 || y == m || x == -1 || x == n)) { //meet edge
                        isMeetEdge = true;
                    }
                }
            }
            return isMeetEdge;
        }

        private void init(char[][] board) {
            this.m = board.length;
            this.n = (m == 0) ? 0 : board[0].length;
            this.board = board;
            visited = new boolean[m][n];
            edgeMap = new boolean[m][n];
            q = new LinkedList<>();
            island = new LinkedList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}