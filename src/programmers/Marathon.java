package programmers;

import java.util.*;

/*
완주하지 못한 선수
https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Marathon {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String s : participant) {
            if (participantMap.get(s) == null) {
                participantMap.put(s, 1);
            } else {
                participantMap.put(s, participantMap.get(s) + 1);
            }
        }

        for (String s : completion) {
            if (participantMap.get(s) == 1) {
                participantMap.remove(s);
            } else {
                participantMap.put(s, participantMap.get(s) -1);
            }
        }

        for (String s : participantMap.keySet()) {
            return s;
        }
        return null;
    }
}
