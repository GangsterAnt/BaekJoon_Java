package programmers;


import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */

public class TravelPath {
    public static void main(String[] args) {
        TravelPath object = new TravelPath();
        String[][] s = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] s = {{"ICN", "BBB"},{"ICN", "CCC"}, {"CCC", "BBB"}};
        String[] solution1 = object.solution(s);

        for (String string : solution1) {
            System.out.print(string + " ");
        }
    }

    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    static List<String> answerSheet = new ArrayList<>();
    static int[][] board;

    public String[] solution(String[][] tickets) {
        int size = 0;
        int ticketSize = tickets.length;

        //get size and init airport into
        for (int i = 0; i < tickets.length; ++i) {
            String a = tickets[i][0];
            String b = tickets[i][1];
            if (map.get(a) == null) {
                map.put(a, size++);
                list.add(a);
            }
            if (map.get(b) == null) {
                map.put(b, size++);
                list.add(b);
            }
        }

        board = new int[size][size];

        //init board
        for (int i = 0; i < tickets.length; ++i) {
            String a = tickets[i][0];
            String b = tickets[i][1];
            board[map.get(a)][map.get(b)]++;
        }


        //start bfs

        dfs(0, ticketSize, map.get("ICN"), "ICN", answerSheet);
        Collections.sort(answerSheet);
        if (answerSheet.isEmpty()) {
            return new String[]{};
        }
        return answerSheet.get(0).split(",");
    }

    private void dfs(int currentDepth, int goalDepth, int currentNode, String currentList, List<String> answerSheet) {
        if (currentDepth == goalDepth) {
            answerSheet.add(currentList);
            return;
        }

        for (int i = 0; i < board.length; ++i) {
            if (board[currentNode][i] != 0) {
                board[currentNode][i]--;
                dfs(currentDepth + 1, goalDepth, i, currentList + "," + list.get(i), answerSheet);
                board[currentNode][i]++;
            }
        }
    }
}
