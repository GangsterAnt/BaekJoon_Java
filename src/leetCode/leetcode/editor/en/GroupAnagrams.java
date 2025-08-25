package leetCode.leetcode.editor.en;

//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: strs = ["eat","tea","tan","ate","nat","bat"] 
// 
//
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// Explanation: 
//
// 
// There is no string in strs that can be rearranged to form "bat". 
// The strings "nat" and "tan" are anagrams as they can be rearranged to form 
//each other. 
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged 
//to form each other. 
// 
//
// Example 2: 
//
// 
// Input: strs = [""] 
// 
//
// Output: [[""]] 
//
// Example 3: 
//
// 
// Input: strs = ["a"] 
// 
//
// Output: [["a"]] 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 20461 👎 685

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        boolean[] visited;
        Map<String, List<String>> answerList;
        int length;

        int[] anagramSource;
        int[] anagramTarget;
    public List<List<String>> groupAnagrams(String[] strs) {
        init(strs);

        for (int i =0; i< length; ++i) {
            if (visited[i]) continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            answerList.put(strs[i], temp);
            for (int ii = 0; ii< length; ++ii) {
                if (i != ii && !visited[ii] && checkAnagram(strs[i],strs[ii])) {
                    updateAnswerMap(strs[i], strs[ii]);
                    visited[ii] = true;
                }
            }
            visited[i] = true;
        }

        return convertResult();
    }

        private List<List<String>> convertResult() {
            List<List<String>> finalResult = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : answerList.entrySet()) {
                finalResult.add(entry.getValue());
            }
            return finalResult;
        }

        private void updateAnswerMap(String a, String b) {
            answerList.get(a).add(b);
        }

        private boolean checkAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        anagramSource = new int[26];
        anagramTarget = new int[26];

        for (int i = 0; i < a.length(); ++i) {
            anagramSource[a.charAt(i) - 'a']++;
            anagramTarget[b.charAt(i) - 'a']++;
        }

        return Arrays.equals(anagramSource, anagramTarget);
    }

    private void  init(String[] strs) {
        this.length = strs.length;
        visited = new boolean[length];
        answerList = new HashMap<>();
    }

    /*
    지피티 풀이
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // 배열을 String으로 변환 (ex: "#1#0#2#0..." 등)
        StringBuilder sb = new StringBuilder();
        for (int c : count) {
            sb.append('#').append(c);
        }

        String key = sb.toString();
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(map.values());
}
     */
}
//leetcode submit region end(Prohibit modification and deletion)

}