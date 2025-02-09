package codility;

/*
https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/

For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:

  A[0] =  1
  A[1] =  5
  A[2] =  2
  A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..20,000];
each element of array A is an integer within the range [−100..100].

 */

import java.util.*;
import java.util.stream.Collectors;


// Chat GPT 생성. 타임아웃 남
public class MinAbsSum {
    public int solution(int[] A) {
        // 1. 절대값 배열 생성 및 총합 계산
        int sum = 0;
        for (int num : A) {
            sum += Math.abs(num);
        }

        // 2. DP 배열 초기화 (최대 합의 절반만 고려)
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true; // 합이 0은 항상 가능

        // 3. DP 갱신
        for (int num : A) {
            int absNum = Math.abs(num);
            for (int j = sum / 2; j >= absNum; j--) {
                dp[j] = dp[j] || dp[j - absNum];
            }
        }

        // 4. 가능한 최대 절반 합 찾기
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[j]) {
                return sum - 2 * j; // 최소 절대값 계산
            }
        }

        return sum; // 기본적으로 반환하지 않지만 안전을 위해 추가
    }
}
