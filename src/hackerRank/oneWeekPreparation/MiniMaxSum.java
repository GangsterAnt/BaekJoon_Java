package hackerRank.oneWeekPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one
 */
public class MiniMaxSum {

    /*
    솔루션 1 : dfs
    솔루션 2 : 정렬후 앞 4개 최소, 뒤 4개 최대 O(n Log n )
    솔루션 3 : 다더하고 하나씩 빼고 최대 최소 갱신 O(n)
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        boolean[] visited = new boolean[5];
        long[] result = new long[2];
        result[0] = 0; // max
        result[1] = Long.MAX_VALUE;
        dfs(result, 0, 0, visited, arr);

        System.out.print(result[1] + " " + result[0]);
    }

    private static void dfs(long[] result,
                            int depth,
                            long currentVal,
                            boolean[] visited,
                            List<Integer> arr
    ) {
        if (depth == 4) {
            result[0] = Math.max(result[0], currentVal);
            result[1] = Math.min(result[1], currentVal);
            return;
        }

        for (int i = 0; i < 5; ++i) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                dfs(result, depth + 1, currentVal + arr.get(i), visited, arr);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MiniMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
