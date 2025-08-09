package codility;
/*
https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
 */

import java.util.Arrays;

public class NumberOfDiscIntersections {
/*
놓쳤던것 : 원 안엔 원이있는경우도 intersect.

 */

    public static void main(String[] args) {

        NumberOfDiscIntersections sut = new NumberOfDiscIntersections();

        System.out.println(sut.solution(new int[]{1, 5, 2, 1, 4, 0}));
    }


    public int solution(int[] A) {
        long[] minArr = new long[A.length];
        long[] maxArr = new long[A.length];
        int result = 0;

        for (int i =0; i< A.length; ++i) {
            minArr[i] = i - A[i];
            maxArr[i] = i + A[i];
        }

        Arrays.sort(minArr);
        Arrays.sort(maxArr);

        for (int i = 0; i <A.length; ++i) {
            for (int ii = i+1; ii < A.length; ++ii) {
                if (maxArr[i] >= minArr[ii]) {
                    result ++;
                }
            }
        }

        return result;
    }

}
