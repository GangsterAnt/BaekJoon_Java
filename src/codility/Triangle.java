package codility;

import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
 *
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 *
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 *
 * For example, given array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 *
 *   A[0] = 10    A[1] = 50    A[2] = 5
 *   A[3] = 1
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Triangle {

    public int solution(int[] A) {
        Arrays.sort(A);

        long a,b,c;
        for (int i =2; i < A.length; ++i) {
            a = A[i-2];
            b = A[i-1];
            c = A[i];
            /*
            정렬된 상태에서는 a + b > c만 확인하면 됨
            a ≤ b ≤ c 이므로 다른 조건은 자동으로 만족
             */
            if (sumCheck(a,b,c) && sumCheck(b, a,c) && sumCheck(c,a,b)) {
                return 1;
            }
        }

        return 0;
    }

    private boolean sumCheck(long a, long b, long c) {
        return a < b +c;
    }
}
