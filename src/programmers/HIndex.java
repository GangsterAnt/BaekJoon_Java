package programmers;

import java.util.*;


/*
https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java
 */
public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
