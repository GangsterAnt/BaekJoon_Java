package leetCode.leetcode.editor.en;

//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 12714 👎 353


import java.util.*;


public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();

        List<Integer> anagrams = solution.findAnagrams("cbaebabacd", "abc"); //0,6

        anagrams = solution.findAnagrams("abab", "ab"); //0,1,2

        anagrams = solution.findAnagrams("baa", "aa"); //1

        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, Integer> charMap;
        Map<Character, Integer> answerMap;
        int targetLength;
        int inputLength;
        List<Integer> result;

        public List<Integer> findAnagrams(String s, String p) {
            init(s, p);

            if (s.length() < p.length()) {
                return result;
            }

            String temp = s.substring(0, p.length());
            for (int i = 0; i < temp.length(); ++i) {
                if (answerMap.get(temp.charAt(i)) != null) {
                    answerMap.put(temp.charAt(i), answerMap.get(temp.charAt(i)) + 1);
                }
            }
            if (isAllTrue()) {
                result.add(0);
            }

            for (int i= 1; i <= s.length() - p.length(); ++i) {
                //remove i-1
                if (answerMap.get(s.charAt(i-1)) != null) {
                    answerMap.put(s.charAt(i - 1),answerMap.get(s.charAt(i-1)) - 1);
                }
                //add i+ p.length -1
                if (answerMap.get(s.charAt(i + p.length() -1)) != null) {
                    answerMap.put(s.charAt(i + p.length() -1), answerMap.get(s.charAt(i + p.length() -1)) +1);
                    if (isAllTrue()) {
                        result.add(i);
                    }
                }
            }



            return result;
        }

        private boolean isAllTrue() {
            for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
                if (!Objects.equals(entry.getValue(), answerMap.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }

        private void init(String input, String target) {
            this.inputLength = input.length();
            this.targetLength = target.length();
            result = new ArrayList<>();
            charMap = new HashMap<>();
            answerMap = new HashMap<>();
            for (int i = 0; i < targetLength; ++i) {
                if (charMap.get(target.charAt(i)) == null) {
                    charMap.put(target.charAt(i), 1);
                } else {
                    charMap.put(target.charAt(i), charMap.get(target.charAt(i)) +1);
                }
                answerMap.put(target.charAt(i), 0);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    /*
    //지피티 풀이
    class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] targetMap = new int[26];
        int[] windowMap = new int[26];

        for (char c : p.toCharArray()) {
            targetMap[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            windowMap[s.charAt(i) - 'a']++;

            // window size 유지
            if (i >= p.length()) {
                windowMap[s.charAt(i - p.length()) - 'a']--;
            }

            // 비교
            if (Arrays.equals(targetMap, windowMap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}

     */
}