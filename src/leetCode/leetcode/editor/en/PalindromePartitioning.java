package leetCode.leetcode.editor.en;

//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 13476 👎 541


import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        List<List<String>> result = solution.partition("aab");
        System.out.println(result);

        result = solution.partition("a");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> result;
        int length;
        String target;

        public List<List<String>> partition(String s) {
            init(s);
            dfs(new ArrayList<>(),0, 1);
            return result;
        }

        private void dfs(List<String> tempResult, int start, int end) {
            if (start == length) {
                result.add(new ArrayList<>(tempResult));
            }
            String temp;
            for (int i = end; i <= length; ++i) {
                 temp = target.substring(start, i);
                if (isPalindrome(temp)) {
                    tempResult.add(temp); // visit
                    dfs(tempResult, i, i + 1);
                    tempResult.remove(tempResult.size() -1); //unvisit
                }
            }
        }

        private void init(String s) {
            this.length = s.length();
            this.target = s;
            result = new ArrayList<>();
        }

        private boolean isPalindrome(String temp) {
            if (temp.length() == 1) {
                return true;
            }

            for (int i = 0; i < temp.length() / 2; ++i) {
                if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}