package programmers;


import java.util.*;


//https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
public class BiPQ {

    public static void main(String[] args) {
        BiPQ biPQ = new BiPQ();

        biPQ.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
    }


    public int[] solution(String[] operations) {
        final String REMOVE_MAX = "D 1";
        final String REMOVE_MIN = "D -1";

        List<Integer> dq = new LinkedList<>();

        for (int i = 0; i < operations.length; ++i) {
            String operation = operations[i];

            if (REMOVE_MAX.equals(operation) ) {
                if (!dq.isEmpty()){
                    dq.remove(dq.remove(dq.size() - 1));
                }
            } else if (REMOVE_MIN.equals(operation) && !dq.isEmpty()) {
                if (!dq.isEmpty()) {
                    dq.remove(0);
                }
            } else {
                String[] split = operation.split(" ");
                dq.add(Integer.valueOf(split[1]));
                Collections.sort(dq);
            }

            for (Integer in : dq) {
                System.out.print(in + " ");
            }
            System.out.println();
        }

        int[] answer = new int[]{0,0};
        if (!dq.isEmpty()) {
            answer[0] = dq.get(dq.size()-1);
            answer[1] = dq.get(0);
        }
        return answer;
    }
}
