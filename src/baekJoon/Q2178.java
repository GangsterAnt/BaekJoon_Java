package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2178
미로 탐색
bfs
 */
public class Q2178 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        //init map
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        //bfs start from 0,0 to n-1, m-1

        Integer result = bfs(map, visited, n, m);
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(boolean[][] map, boolean[][] visited, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            int dist = p.dist;

            if (y == n - 1 && x == m - 1) {
                return dist;
            }

            //up
            if (y - 1 >= 0 && map[y - 1][x] && !visited[y - 1][x]) {
                q.add(new Pair(y - 1, x, dist + 1));
                visited[y - 1][x] = true;
            }

            //down
            if (y + 1 <= n - 1 && map[y + 1][x] && !visited[y + 1][x]) {
                q.add(new Pair(y + 1, x, dist + 1));
                visited[y + 1][x] = true;
            }

            //left
            if (x - 1 >= 0 && map[y][x - 1] && !visited[y][x - 1]) {
                q.add(new Pair(y, x - 1, dist + 1));
                visited[y][x - 1] = true;
            }

            //right
            if (x + 1 <= m - 1 && map[y][x + 1] && !visited[y][x + 1]) {
                q.add(new Pair(y, x + 1, dist + 1));
                visited[y][x + 1] = true;
            }
        }

        return -1;
    }

    public static class Pair {
        int y;
        int x;
        int dist;

        public Pair(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
