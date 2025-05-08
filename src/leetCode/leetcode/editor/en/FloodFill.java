package leetCode.leetcode.editor.en;

//You are given an image represented by an m x n grid of integers image, where 
//image[i][j] represents the pixel value of the image. You are also given three 
//integers sr, sc, and color. Your task is to perform a flood fill on the image 
//starting from the pixel image[sr][sc]. 
//
// To perform a flood fill: 
//
// 
// Begin with the starting pixel and change its color to color. 
// Perform the same process for each pixel that is directly adjacent (pixels 
//that share a side with the original pixel, either horizontally or vertically) and 
//shares the same color as the starting pixel. 
// Keep repeating this process by checking neighboring pixels of the updated 
//pixels and modifying their color if it matches the original color of the starting 
//pixel. 
// The process stops when there are no more adjacent pixels of the original 
//color to update. 
// 
//
// Return the modified image after performing the flood fill. 
//
// 
// Example 1: 
//
// 
// Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2 
// 
//
// Output: [[2,2,2],[2,2,0],[2,0,1]] 
//
// Explanation: 
//
// 
//
// From the center of the image with position (sr, sc) = (1, 1) (i.e., the red 
//pixel), all pixels connected by a path of the same color as the starting pixel (
//i.e., the blue pixels) are colored with the new color. 
//
// Note the bottom corner is not colored 2, because it is not horizontally or 
//vertically connected to the starting pixel. 
//
// Example 2: 
//
// 
// Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0 
// 
//
// Output: [[0,0,0],[0,0,0]] 
//
// Explanation: 
//
// The starting pixel is already colored with 0, which is the same as the 
//target color. Therefore, no changes are made to the image. 
//
// 
// Constraints: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], color < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 8861 ?
//? 912


import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        Solution solution = new FloodFill().new Solution();

        //Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        int[][] image = new int[3][3];
        int[][] ret;
        image[0] = new int[]{1,1,1};
        image[1] = new int[]{1,1,0};
        image[2] = new int[]{1,0,1};
        ret = solution.floodFill(image, 1, 1, 2);

        //Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
        image = new int[2][3];
        image[0] = new int[]{0,0,0};
        image[1] = new int[]{0,0,0};
        ret = solution.floodFill(image, 0, 0, 0);

        ret = solution.floodFill(image, 1, 0, 2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int m; //row
        int n; //column
        int sr;
        int sc;
        int targetColor;
        int startColor;
        int[][] image;
        boolean[][] visited;
        Queue<Pair> q;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        init(image, sr, sc, color);
        bfs();
        return this.image;
    }

    private void bfs() {
        Pair start = new Pair(this.sr, this.sc);
        visited[sr][sc] = true;
        q.add(start);

        Pair temp;
        while (!q.isEmpty()) {
            temp = q.poll();
            image[temp.r][temp.c] = targetColor;
            updatedQ(temp);
        }
    }

        private void updatedQ(Pair currentPair) {
        int r = currentPair.r;
        int c= currentPair.c;

        if (0 <= r-1 && !visited[r-1][c] && image[r-1][c] == startColor) {
            visited[r-1][c] = true;
            q.add(new Pair(r-1, c));
        }

        if (r+1 < m && !visited[r+1][c] && image[r+1][c] == startColor) {
            visited[r+1][c] = true;
            q.add(new Pair(r+1, c));
        }

        if (0 <= c-1 && !visited[r][c-1] && image[r][c-1] == startColor) {
            visited[r][c-1] = true;
            q.add(new Pair(r, c-1));
        }

        if (c+1 < n && !visited[r][c+1] && image[r][c+1] == startColor) {
            visited[r][c+1] = true;
            q.add(new Pair(r, c+1));
        }
    }




    private void init(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.sr = sr;
        this.sc = sc;
        this.targetColor = color;
        this.startColor = image[sr][sc];

        this.m = image.length;
        this.n = (m == 0) ? 0 : image[0].length;

        this.visited = new boolean[m][n];
        this.q = new LinkedList<>();
    }

    private static class Pair {
        public int r;
        public int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}