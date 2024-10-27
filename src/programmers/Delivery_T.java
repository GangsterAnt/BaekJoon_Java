package programmers;

import java.util.*;

public class Delivery_T {
    public static void main(String[] args) {
        Delivery_T s = new Delivery_T();

        int[] solution = s.solution(5, new int[][]{{1, 2, 3}, {1, 4, 4}, {2, 3, 1}, {2, 5, 2}, {3, 5, 1}, {4, 5, 2}}, new int[]{4, 2, 3});
//        int[] solution = s.solution(6, new int[][]{{1, 2, 2}, {1, 5, 1}, {2, 3, 1}, {2, 4, 2}, {2, 6, 3}, {3, 4, 2}, {4,5,1}}, new int[]{1,3});
//        int[] solution = s.solution(4, new int[][]{{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {1, 4, 5}}, new int[]{1, 3});
//        int[] solution =   s.solution(6, new int[][]{{1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {2, 5, 10}, {5, 6, 2}}, new int[]{3});

        for (int a : solution) {
            System.out.print(a + " ");
        }
    }

    static int[][] map;
    static int size;

    static int[][] distanceList;
    public int[] solution(int V, int[][] road, int[] branch){
        //init map
        size = V+1;
        map = new int[size][size];
        for (int i = 1; i < size; ++i) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i =0; i< road.length; ++i) {
            if (map[road[i][0]][road[i][1]] <= road[i][2]) {
                continue;
            }
            map[road[i][0]][road[i][1]] = road[i][2];
            map[road[i][1]][road[i][0]] = road[i][2];
        }

        distanceList = new int[branch.length][size];
        for (int i =0; i<branch.length; ++i) {
            distanceList[i] = bfs(branch[i]);
        }

        int[] answer = new int[V];

        for (int i =0; i<V; ++i) {
            int closestDistance = Integer.MAX_VALUE;
            int closestBranch = 0;

            for (int ii=0; ii <branch.length; ++ii) {
                int distanceFromBranch = distanceList[ii][i+1];
                if (closestDistance > distanceFromBranch) {
                    closestBranch = branch[ii];
                    closestDistance = distanceFromBranch;
                } else if(closestDistance == distanceFromBranch) {
                    closestBranch = Math.min(closestBranch, branch[ii]);
                }
            }
            answer[i] = closestBranch;
        }

        return answer;
    }

    private int[] bfs(int branch) {
        int[] result = new int[size];
        Arrays.fill(result, Integer.MAX_VALUE); //거리 최대로

        // 시작 지점의 거리 0으로 초기화
        result[branch] = 0;

        // 우선순위 큐 생성 (거리, 마을 번호)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, branch}); // (거리, 마을 번호)

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int currentDistance = poll[0];
            int currentTown = poll[1];

            // 이미 처리된 경우 skip
            if (currentDistance > result[currentTown]) {
                continue;
            }
            System.out.println();

            // 인접 마을 탐색
            for (int i = 1; i < size; i++) {
                if (map[currentTown][i] != Integer.MAX_VALUE) { // 연결된 마을인지 확인
                    int newDistance = currentDistance + map[currentTown][i];

                    // 더 짧은 경로 발견 시 업데이트
                    if (newDistance < result[i]) {
                        result[i] = newDistance;
                        pq.add(new int[]{newDistance, i});
                    }
                }
            }
        }

        return result;
    }

}
