package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class NumOfKth {

    private int[] array;
    private int[][] commands;

    private int[] answer;
    private int answerSize;

    public static void main(String[] args) {
        NumOfKth n = new NumOfKth();

        n.solution(new int[]{1,5,2,6,3,7,4}, new int[][]{new int[]{2,5,3}, new int[]{4,4,1}, new int[]{1,7,3}});
    }

    public int[] solution(int[] array, int[][] commands) {
        init(array, commands);
        for(int i = 0; i < commands.length; ++i) {
            List<Integer> subList = new ArrayList<>();
            int[] command = commands[i];

            for (int ii = command[0] -1; ii < command[1]; ++ii) {
                subList.add(array[ii]);
            }

            Collections.sort(subList);
            answer[i] = subList.get(command[2]-1);
        }
        return answer;
    }

    private void init(int[] array, int[][] commands) {
        this.array = array;
        this.commands = commands;
        this.answerSize = commands.length;
        this.answer = new int[answerSize];
    }

}
