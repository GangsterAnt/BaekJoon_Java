package leetCode.leetcode.editor.en;

//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 22074 👎 1029


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();

        List<String> result = solution.generateParenthesis(1);
        System.out.println(result);
        result = solution.generateParenthesis(3);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> result;
        int n;
        int targetLength;

        int openedParentheses;
        int closeableParentheses;

        public List<String> generateParenthesis(int n) {
            init(n);

            if (n == 0) {
                return result;
            }

            StringBuilder sb = new StringBuilder("(");
            this.closeableParentheses++;
            openedParentheses++;
            dfs(sb);
            return result;
        }

        private void dfs(StringBuilder sb) {
            if (sb.length() == targetLength) {
                result.add(sb.toString());
            }

            //조건 체크. 더 열수있는가
            if (openedParentheses < n) {
                sb.append("(");
                openedParentheses++;
                closeableParentheses++;
                dfs(sb);
                sb.deleteCharAt(sb.length() - 1);
                openedParentheses--;
                closeableParentheses--;
            }

            //조건 체크. 닫을수 있는가
            if (closeableParentheses != 0) {
                sb.append(")");
                closeableParentheses--;
                dfs(sb);
                sb.deleteCharAt(sb.length() - 1);
                closeableParentheses++;
            }
        }

        private void init(int n) {
            this.n = n;
            this.openedParentheses = 0;
            this.closeableParentheses = 0;
            this.targetLength = n * 2;
            this.result = new ArrayList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}