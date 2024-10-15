package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailureRate {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[] ans = sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] ans = sol.solution(4, new int[]{4, 4, 4, 4, 4});
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}

class Solution {

    //N 은 전체 스테이지 갯수, int[]는 각 고객들이 막혀있는 스테이지 레벨
    public int[] solution(int N, int[] stages) {

        //각각의 stage를 순회하면서 리스트를 채운다.
        int[] tempAns = new int[N + 1];
        for (int blockedStage : stages) {
            if (blockedStage == N + 1) {
                continue;
            } else {
                tempAns[blockedStage]++;
            }
        }

        //Stage 마다 실패율 구하기.
        float[] failureRate = new float[N + 1];
        int nonBlockedUser = stages.length;
        for (int i = 1; i < N + 1; ++i) {
            if ( nonBlockedUser == 0) {
                failureRate[i] = 0;
            } else {
                failureRate[i] = (float) tempAns[i] / nonBlockedUser;
            }
            nonBlockedUser = nonBlockedUser - tempAns[i]; //i 스테이지에서 막힌 사람은 다음 스테이지 계산의 고려대상이 아니다.
        }

        //pair만들기?
        List<Pair> pairList = new ArrayList<>();
        for (int i = 1; i < N + 1; ++i) {
            pairList.add(new Pair(i, failureRate[i]));
        }
        Collections.sort(pairList);

        //trim tempAns
        int[] answer = new int[N];
        for (int i = 0; i < N; ++i) {
            answer[i] = pairList.get(i).stage;
        }
        return answer;
    }
}

class Pair implements Comparable<Pair> {

    public Pair(int stage, float failureRate) {
        this.stage = stage;
        this.failureRate = failureRate;
    }

    int stage;
    float failureRate;

    @Override
    public int compareTo(Pair o) {
        if (this.failureRate == o.failureRate) {
            return Integer.compare(this.stage, o.stage);
        }
        return Float.compare(o.failureRate, this.failureRate);
    }
}
