package leetCode.leetcode.editor.en;

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 19638 👎 1063


import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();

        List<String> case1 = solution.letterCombinations("23");
        List<String> case2 = solution.letterCombinations("");
        List<String> case3 = solution.letterCombinations("2");

        List<String> caseEnd = solution.letterCombinations("2");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[] two = new char[]{'a', 'b', 'c'};
        char[] three = new char[]{'d', 'e', 'f'};
        char[] four = new char[]{'g', 'h', 'i'};
        char[] five = new char[]{'j', 'k', 'l'};
        char[] six = new char[]{'m', 'n', 'o'};
        char[] seven = new char[]{'p', 'q', 'r', 's'};
        char[] eight = new char[]{'t', 'u', 'v'};
        char[] nine = new char[]{'w', 'x', 'y', 'z'};
        char[][] numPad;

        List<String> result;
        int length;

        String digits;

        public List<String> letterCombinations(String digits) {
            init(digits);
            if ("".equals(digits)) {
                return result;
            }
            dfs("", 0, digits.charAt(0));
            return result;
        }

        private void dfs(String temp, int depth, char target) {
            if (depth == length) {
                result.add(temp);
                return;
            }
            char[] targetNumPad = numPad[target - '0'];

            for (char c : targetNumPad) {
                dfs(temp + c, depth + 1, digits.charAt(depth + 1));
            }
        }

        private void init(String digits) {
            numPad = new char[10][];
            numPad[2] = two;
            numPad[3] = three;
            numPad[4] = four;
            numPad[5] = five;
            numPad[6] = six;
            numPad[7] = seven;
            numPad[8] = eight;
            numPad[9] = nine;
            result = new ArrayList<>();
            length = digits.length();
            this.digits = digits + " ";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}