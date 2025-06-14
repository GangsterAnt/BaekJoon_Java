package programmers;

import java.security.Key;
import java.util.*;
import java.util.Map;

/*
키패드 누르기

https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class KeyPad {
    public static void main(String[] args) {
        KeyPad keyPad = new KeyPad();

//        System.out.println(keyPad.solution(new int[]{}, "right"));
        System.out.println(keyPad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(keyPad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(keyPad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    boolean rightHanded;
    int[] currentLeft;
    int[] currentRight;
    StringBuilder answer;
    int currentNum;

    static final int[] one = new int[]{0,0};
    static final int[] two = new int[]{0,1};
    static final int[] three = new int[]{0,2};

    static final int[] four = new int[]{1,0};
    static final int[] five = new int[]{1,1};
    static final int[] six = new int[]{1,2};

    static final int[] seven = new int[]{2,0};
    static final int[] eight = new int[]{2,1};
    static final int[] nine = new int[]{2,2};

    static final int[] zero = new int[]{3,1};

    static final String L = "L";
    static final String R = "R";

   static Map<Integer, int[]> map;


    public String solution(int[] numbers, String hand) {
        init(hand);

        for (int i =0; i < numbers.length; ++i) {
            currentNum = numbers[i];
            if (isDefaultRightHandTarget(currentNum)) {
                currentRight = map.get(currentNum);
                answer.append("R");
            } else if (isDefaultLeftHandTarget(currentNum)) {
                currentLeft = map.get(currentNum);
                answer.append("L");
            } else {
                neutralTarget(currentNum);
            }
        }

        return answer.toString();
    }

    private void init(String hand) {
        //init
        this.answer = new StringBuilder();
        this.rightHanded = "right".equals(hand);
        this.currentLeft = new int[]{3,0};
        this.currentRight = new int[]{3,2};

        map = new HashMap<>();
        map.put(1, one);
        map.put(2, two);
        map.put(3, three);
        map.put(4, four);
        map.put(5, five);
        map.put(6, six);
        map.put(7, seven);
        map.put(8, eight);
        map.put(9, nine);
        map.put(0, zero);
    }

    private boolean isDefaultRightHandTarget(int targetNum) {
        return targetNum == 3 || targetNum == 6 || targetNum == 9;
    }
    private boolean isDefaultLeftHandTarget(int targetNum) {
        return targetNum == 1 || targetNum == 4 || targetNum == 7;
    }

    private void neutralTarget(int targetNum) {
        int left = getDist(targetNum, currentLeft);
        int right = getDist(targetNum, currentRight);

        if (left < right) {
            currentLeft = map.get(targetNum);
            answer.append(L);
        } else if (left > right) {
            currentRight = map.get(targetNum);
            answer.append(R);
        } else {
            if (rightHanded) {
                currentRight = map.get(targetNum);
                answer.append(R);
            } else {
                currentLeft = map.get(targetNum);
                answer.append(L);
            }

        }
    }

    private int getDist(int targetNum, int[] handPosition) {
        return Math.abs(map.get(targetNum)[0] - handPosition[0]) + Math.abs(map.get(targetNum)[1] - handPosition[1]);
    }

}
