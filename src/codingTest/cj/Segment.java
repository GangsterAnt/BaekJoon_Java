package codingTest.cj;

/*
기본 상태의 7 세그먼트 3개 (숫자)
4세그먼트 1개 (사칙연산)
2세그먼트 1개 (등호)
등호에는 항상 불이 들어와있다

0 -> 6
1 -> 2
2 -> 5
3 -> 5
4 -> 4
5 -> 5
6 -> 6
7 -> 3
8 -> 7
9 -> 6

7세그먼트의 불이 들어오는 개수는 2개 이상이어야 한다.

+ -> 2
- -> 1
/ -> 1 나누기는 몫
* -> 2
= -> 2

정수 n이 주어졌을때 올바른 등식을 만들수 있는 경우의 수를 구하는 문제
 */

import java.util.*;

public class Segment {

    public static void main(String[] args) {
        Segment segment = new Segment();
        System.out.println(segment.solution(21)); // 4
        System.out.println(segment.solution(0)); // 0
    }

    static final Map<Character, Integer> segMap = Map.ofEntries(
            Map.entry('0', 6),
        Map.entry('1', 2),
        Map.entry('2', 5),
        Map.entry('3', 5),
        Map.entry('4', 4),
        Map.entry('5', 5),
        Map.entry('6', 6),
        Map.entry('7', 3),
        Map.entry('8', 7),
        Map.entry('9', 6),

    // 사칙연산
        Map.entry('+', 2),
        Map.entry('-', 1),
        Map.entry('*', 2),
        Map.entry('/', 1),
    // 등호
        Map.entry('=', 2)
    );
    int left;
    int right;
    int result;

    static final Character[] operators = new Character[]{'+', '-', '*', '/'};

    int answer;
    int currentSeg; //default 0

    public int solution(int n) {
        init();
        if (n < 7) {
            return 0; // 최소 8개가 필요 1 - 1, 1 (2,1,2,2)
        }


        for (int i = 0; i <= 9; ++i) {
            left = i;
            currentSeg += segMap.get((char) ('0' + left));
            for (int j = 0; j <= 9; ++j) {
                right = j;
                currentSeg += segMap.get((char) ('0' + right));
                for (int k = 0; k <= 9; ++k) {
                    result = k;
                    currentSeg += segMap.get((char) ('0' + result));
                    for (Character operator : operators) {
                        if (currentSeg + segMap.get(operator) != n) continue;
                        if (calculateCorrect(operator)) {
                            answer++;
                        }
                    }
                    currentSeg -= segMap.get((char) ('0' + result));
                }
                currentSeg -= segMap.get((char) ('0' + right));
            }
            currentSeg -= segMap.get((char) ('0' + left));
        }


        return answer;
    }

    private boolean calculateCorrect(Character operator) {
        if (operator == '+') {
            return left + right == result;
        } else if (operator == '-') {
            return left - right == result;
        } else if (operator == '*') {
            return left * right == result;
        } else if (operator == '/') {
            return right != 0 && left / right == result;
        }

        return false;
    }

    private void init() {
        answer = 0;
        currentSeg = 0; //default 0
    }
}
