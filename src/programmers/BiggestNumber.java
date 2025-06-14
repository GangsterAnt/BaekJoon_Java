package programmers;

import java.util.Arrays;

/*
가장 큰 수
https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */
public class BiggestNumber {
    public static void main(String[] args) {

    }

    public String solution(int[] numbers) {
        int length = numbers.length;
        String[] strings = new String[length];

        boolean onlyZero = true;
        for (int i=0; i< length; ++i) {
            strings[i] = String.valueOf(numbers[i]);
            if (numbers[i] != 0) {
                onlyZero = false;
            }
        }

        Arrays.sort(strings, (o1, o2) -> (o2+o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();

        for (String s : strings) {
            sb.append(s);
        }
        if (onlyZero) {
            return "0";
        }
        return sb.toString();
    }
}
