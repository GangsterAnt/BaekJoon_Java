package codility;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * <p>
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * content_copy
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {

    public int solution(int[] A) {
        int max = Arrays.stream(A).max().orElse(0);
        Set<Integer> collect = Arrays.stream(A).boxed().collect(Collectors.toSet());

        for (int i =1; i < max; ++i) {
            if (!collect.contains(i)) {
                return i;
            }
        }

        return max+1;
    }
}
