package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java
 */
public class FarestNode {

    public static void main(String[] args) {
        int[][] edge = new int[][]{
                new int[]{3, 6},
                new int[]{4, 3},
                new int[]{3, 2},
                new int[]{1, 3},
                new int[]{1, 2},
                new int[]{2, 4},
                new int[]{5, 2}
        };

        FarestNode farestNode = new FarestNode();
        System.out.println(farestNode.solution(6, edge));
    }

    public int solution(int n, int[][] edge) {
        boolean[][] board = new boolean[n + 1][n + 1];

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Queue<Pair> q = new LinkedList<>();

        int x = 0, y = 0;

        for (int i = 0; i < edge.length; ++i) {
            x = edge[i][0];
            y = edge[i][1];
            board[x][y] = true;
            board[y][x] = true;
        }
        visited[1] = true;
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            distance[poll.l] = poll.r;

            for (int i = 1; i < n + 1; ++i) {
                if (board[i][poll.l] && !visited[i]) {
                    q.add(new Pair(i, poll.r+1));
                    visited[i] = true;
                }
            }
        }

        int max = -1;
        int num = -1;
        for (int i =1; i< n+1; ++i) {
            if (distance[i] == max) {
                num++;
            } else if (distance[i] > max) {
                num = 1;
                max = distance[i];
            }
        }

        return num;
    }

    class Pair {
        public int l;
        public int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
