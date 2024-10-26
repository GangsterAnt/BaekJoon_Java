package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rectangle {
}

class Solution1 {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int[] x = new int [3];
        int[] y = new int[3];

        for (int i=0; i < 3; ++i) {
            x[i] = v[i][0];
            y[i] = v[i][1];
        }

        if (x[0] == x[1]) {
            answer[0] = x[2];
        } else if (x[0] == x[2]) {
            answer[0] = x[1];
        } else {
            answer[0]= x[0];
        }

        if (y[0] == y[1]) {
            answer[0] = y[2];
        } else if (x[0] == y[2]) {
            answer[0] = y[1];
        } else {
            answer[0]= y[0];
        }

        return answer;
    }
}

