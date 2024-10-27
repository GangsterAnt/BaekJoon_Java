package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class WordTransfer {

    public static void main(String[] args) {
        WordTransfer wordTransfer = new WordTransfer();

        System.out.println(wordTransfer.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    static int ans = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        //scan reachable target
        boolean reachableTarget = false;
        for (String word : words) {
            if (target.equals(word)) {
                reachableTarget = true;
            }
        }
        if (!reachableTarget) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; ++i) {
            if (begin.equals(words[i])) {
                visited[i] = true;
            }
        }

        dfs(begin, target, words, visited, 0);
        return ans;
    }

    private void dfs(String current, String target, String[] words, boolean[] visisted, int depth) {
        if (target.equals(current)) {
            ans = Math.min(depth, ans);
        }

        for (int i = 0; i < words.length; ++i) {
            if (!visisted[i] && visitable(current, words[i])) {
                visisted[i] = true;
                dfs(words[i], target, words, visisted, depth + 1);
                visisted[i] = false;
            }
        }


    }

    private boolean visitable(String current, String candidate) {
        int NumOfDiffChar = 0;
        for (int i = 0; i < current.length(); ++i) {
            if (current.charAt(i) != candidate.charAt(i)) {
                NumOfDiffChar++;
            }
        }

        return NumOfDiffChar == 1;
    }
}
