package leetCode.leetcode.editor.en;

//Given two strings text1 and text2, return the length of their longest common 
//subsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both 
//strings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
//
// Related Topics String Dynamic Programming 👍 14235 👎 218


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde","ace"));
        System.out.println(solution.longestCommonSubsequence("abc","def"));
        System.out.println(solution.longestCommonSubsequence("abcba","abcbcba"));
        System.out.println(solution.longestCommonSubsequence("bl","ybyl"));
        System.out.println(solution.longestCommonSubsequence("aab","azb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            text1 = "1" + text1; //add dummy char for index calculation
            text2 = "2" + text2; //add dummy char for index calculation
            int y = text1.length();
            int x = text2.length();
            int[][] dp = new int[y][x];

            for (int i = 1; i < y; ++i) {
                for (int ii = 1; ii < x; ++ii) {
                    if (text1.charAt(i) == text2.charAt(ii)) {
                        dp[i][ii] = dp[i-1][ii-1] +1;
                    } else {
                        dp[i][ii] = Integer.max(dp[i-1][ii], dp[i][ii-1]);
                    }
                }
            }

            return dp[y-1][x-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}