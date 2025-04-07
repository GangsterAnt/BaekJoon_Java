package codingTest.naverShopping;
/*

 */

public class QuestionOne {
    public int solution(int[] start, int[] dest, int[] limit) {
        int largestStation = 0;
        int fee = 0;
        int length = start.length;

        for (int i = 0; i < length; ++i) {
            fee += 1 + Math.abs(start[i] - dest[i]) * 2; // fee for distance
            largestStation = Math.max(largestStation, Math.max(dest[i], start[i])); // find the largest station
        }

        return Math.min(fee, limit[largestStation]);
    }
}
