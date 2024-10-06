package reetCode;

/*
    https://leetcode.com/problems/longest-common-prefix/description/?envType=problem-list-v2&envId=avihny73
 */
public class LongestCommonPrefix {

    // 1 ms,41mb
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        StringBuilder answer = new StringBuilder();
        int shortestLength = getShortestLength(strs);
        char tempChar;
        for (int i = 0; i < shortestLength; ++i) { //check all String's charAti(i)
            tempChar = strs[0].charAt(i);
            for (int ii = 1; ii < length; ++ii) { //check strs[ii]
                if (strs[ii].charAt(i) != tempChar) {
                    return answer.toString();
                }
            }
            answer.append(tempChar);
        }
        return answer.toString();
    }

    public int getShortestLength(String[] strs) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            result = Math.min(result, strs[i].length());
        }
        return result;
    }
    // 11 ms 45mb
//    public String longestCommonPrefix(String[] strs) {
//        long length = strs.length;
//        String answer = strs[0];
//        for (int i = 1; i < length; ++i) {
//           answer = updateAnswer(answer, strs[i]);
//        }
//        return answer;
//    }
//
//    private String updateAnswer(String answer, String str) {
//        String newAnswer = "";
//        long minLength = Math.min(answer.length(), str.length());
//        for (int i = 0; i < minLength; ++i) {
//            if (str.charAt(i) == answer.charAt(i)) {
//                newAnswer += str.charAt(i);
//            } else {
//                break;
//            }
//        }
//
//        return newAnswer;
//    }
}
