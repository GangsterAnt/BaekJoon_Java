package leetCode.leetcode.editor.en;

//Given a string s and a dictionary of strings wordDict, return true if s can 
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics Array Hash Table String Dynamic Programming Trie Memoization ?
//? 17927 👎 855


import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        List<String> temp = new ArrayList<>();

        temp.add("leet");
        temp.add("code");
        solution.wordBreak("leetcode", temp);

        temp.clear();
        temp.add("apple");
        temp.add("pen");
        solution.wordBreak("applepenapple", temp);
        temp.clear();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int length;
        boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        init(s, wordDict);

        for (int i =0; i <= s.length(); ++i) {
            for (int ii = 0; ii < i; ++ii) {
                if (dp[ii] && wordDict.contains(s.substring(ii,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private void init(String s, List<String> wordDict) {
        this.length = s.length();
        this.dp = new boolean[length+1];
        dp[0] = true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}