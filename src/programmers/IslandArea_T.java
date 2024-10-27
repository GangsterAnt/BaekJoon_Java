package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class IslandArea_T {

    public static void main(String[] args) {
        IslandArea_T t = new IslandArea_T();
        int[] solution = t.solution(new String[]{"1101110000", "1100001000", "1000011000", "0000000000", "0000100100", "1110101111"});

        for (int i = 0; i < solution.length; ++i) {
            System.out.print(solution[i] + " ");
        }
    }

    static boolean[][] visited;
    static boolean[][] map;
    static int yMax;
    static int xMax;

    public int[] solution(String[] maps) {
        yMax = maps.length;
        xMax = maps[0].length();
        List<Integer> islandList = new ArrayList<>();

        visited = new boolean[yMax][xMax];
        map = new boolean[yMax][xMax];

        //init map

        for (int i = 0; i < yMax; ++i) { //y
            for (int ii = 0; ii < xMax; ++ii) { //x
                if ('1' == maps[i].charAt(ii)) {
                    map[i][ii] = true;
                }
            }
        }

        for (int i = 0; i < yMax; ++i) { //y
            for (int ii = 0; ii < xMax; ++ii) { //x
                if ('1' == maps[i].charAt(ii) && !visited[i][ii]) {
                    islandList.add(bfs(i, ii));
                }
            }
        }

        islandList = islandList.stream().sorted().distinct().collect(Collectors.toList());

        int[] answer = new int[islandList.size()];
        for (int i = 0; i < islandList.size(); ++i) {

            answer[i] = islandList.get(i);

        }
        return answer;
    }

    private int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        int area = 1;
        q.add(new Pair(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            if (poll.y + 1 < yMax && !visited[poll.y + 1][poll.x] && map[poll.y + 1][poll.x]) {
                visited[poll.y + 1][poll.x] = true;
                area++;
                q.add(new Pair(poll.y + 1, poll.x));
            }
            if (poll.y - 1 >= 0 && !visited[poll.y - 1][x] && map[poll.y - 1][x]) {
                visited[poll.y - 1][poll.x] = true;
                area++;
                q.add(new Pair(poll.y - 1, poll.x));
            }
            if (poll.x - 1 >= 0 && !visited[poll.y][poll.x - 1] && map[poll.y][poll.x - 1]) {
                visited[poll.y][poll.x - 1] = true;
                area++;
                q.add(new Pair(poll.y, poll.x - 1));
            }
            if (poll.x + 1 < xMax && !visited[poll.y][poll.x + 1] && map[poll.y][poll.x + 1]) {
                visited[poll.y][poll.x + 1] = true;
                area++;
                q.add(new Pair(poll.y, poll.x + 1));
            }
        }

        return area;
    }

    private class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
