package baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1260
DFS와 BFS
 */
public class Q1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0; // 정점의 개수
        int m = 0; // 간선의 개수
        int v = 0; // 탐색 시작 간선

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.valueOf(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }
        visited[v] = true;
        bw.write(dfs(map, visited, v, String.valueOf(v)));
        resetVisited(visited, v);
        bw.write("\n");
        bw.write(bfs(map, visited, v));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void resetVisited(boolean[] visited, int v) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[v] = true;
    }

    private static String dfs(int[][] map, boolean[] visited, int v, String result) {
        for (int i = 1; i < map[v].length; ++i) {
            if (map[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                return dfs(map, visited, i, result + " " + i);
            }
        }
        return result;
    }

    private static String bfs(int[][] map, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        String result = String.valueOf(v);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i < map[current].length; ++i) {
                if (map[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    result += " " + i;
                }
            }
        }

        return result;
    }
}
