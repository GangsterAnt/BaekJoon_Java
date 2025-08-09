package codility;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * content_copy
 * <p>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
public class CountDiv {

    public int solution(int A, int B, int K) {
        int first = A%K == 0 ? A : A + (K -A%K);
        int last = B - B %K;

        if (first > B) {
            return 0;
        } else {
            return  (last - first)/ K +1;
        }
    }

    public int solution_fail(int A, int B, int K) {
        int a = (B - A + 1) / K;
        return B - B % K > A + a * K ? a + 1 : a;
    }
}
