package codility;

import java.util.*;

/**
*https://app.codility.com/c/run/training428RAR-RYH/
 **/
public class FirstUnique {

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique();
//        int[] arr = new int[]{4, 10, 5, 4, 2, 10};
//
//        int solution = firstUnique.solution(arr);
//        arr = new int[]{1, 4, 3, 3, 1, 2};
//        solution = firstUnique.solution(arr);
//        arr = new int[]{6, 4, 4, 6};
//        solution = firstUnique.solution(arr);

        int[] arr = new int[]{1,1,1, 4, 3, 3, 2};
        int solution = firstUnique.solution(arr);
        System.out.println("ANSER:" + solution);
//        arr = new int[]{6, 4, 4, 6};
//        solution = firstUnique.solution(arr);
    }

    public int solution(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; ++i){
            if (map.get(A[i]) == null) {
                map.put(A[i], i);
            } else if (map.get(A[i]) != null) {
                map.put(A[i], Integer.MAX_VALUE);
            }
        }

        int index = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < index) {
                index = entry.getValue();
            }
        }

        if (index == Integer.MAX_VALUE) {
            return -1;
        }

        return A[index];
    }
}
