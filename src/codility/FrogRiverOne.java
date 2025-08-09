package codility;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */

import java.util.*;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet();
        for (int i =1; i < X+1; ++i) {
            set.add(i);
        }

        for (int time =0; time < A.length; ++ time) {
            if (set.contains(A[time])) {
                set.remove(A[time]);
            }

            if (set.isEmpty()) {
                return time;
            }
        }

        return -1;
    }
}
