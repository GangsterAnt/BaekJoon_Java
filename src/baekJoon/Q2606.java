package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2606
바이러스
 */
public class Q2606 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n + 1][n + 1];
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = true;
            map[x][y] = true;
        }

        dfs(map, visited, 1);
        bw.write(String.valueOf(visited.size() - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(boolean[][] map, Set<Integer> visited, int v) {
        visited.add(v); // 방문한 노드 추가
        for (int i = 1; i < map.length; ++i) {
            if (map[v][i] && !visited.contains(i)) {
                dfs(map, visited, i);
            }
        }
    }
}
