package leetCode.leetcode.editor.en;

//You have a lock in front of you with 4 circular wheels. Each wheel has 10 
//slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
//freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
//Each move consists of turning one wheel one slot. 
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels. 
//
// You are given a list of deadends dead ends, meaning if the lock displays any 
//of these codes, the wheels of the lock will stop turning and you will be unable 
//to open it. 
//
// Given a target representing the value of the wheels that will unlock the 
//lock, return the minimum total number of turns required to open the lock, or -1 if 
//it is impossible. 
//
// 
// Example 1: 
//
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation: 
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" 
//would be invalid,
//because the wheels of the lock become stuck after the display becomes the 
//dead end "0102".
// 
//
// Example 2: 
//
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation: We can turn the last wheel in reverse to move from "0000" -> "000
//9".
// 
//
// Example 3: 
//
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//Output: -1
//Explanation: We cannot reach the target without getting stuck.
// 
//
// 
// Constraints: 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target will not be in the list deadends. 
// target and deadends[i] consist of digits only. 
// 
//
// Related Topics Array Hash Table String Breadth-First Search 👍 4985 👎 229


import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();

        solution.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"); //6
//        solution.openLock(new String[] {"8888"}, "0009"); // 1
//        solution.openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"); // -1
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Deque<String> q = new LinkedList();
            Map<String, Integer> distMap = new HashMap<>();
            Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));

            if (deadEndSet.contains("0000") ||deadEndSet.contains(target)) {
                return  -1;
            }

            q.add("0000");
            distMap.put("0000", 0);
            String temp;
            List<String> nearCodes;
            int dist;
            while (!q.isEmpty()) {
                temp = q.poll();

                if (target.equals(temp)) {
                    return distMap.get(target);
                }

                dist = distMap.get(temp);
                nearCodes = generateNearCode(temp, deadEndSet, distMap);

                for (String s : nearCodes) {
                    distMap.put(s, dist + 1);
                    q.add(s);
                }

                System.out.println("one cycle done");
            }

            return -1;
        }

        private List<String> generateNearCode(String current, Set<String> deadEndSet, Map<String, Integer> distMap) {
            List<String> ret = new ArrayList<>();

            for (int i = 0; i < 4; ++i) {
                char[] up = current.toCharArray();
                char[] down = current.toCharArray();
                up[i] = up[i] == '9' ? '0' : (char) (up[i] + 1);
                String upStr = new String(up);
                if (!deadEndSet.contains(upStr) && !distMap.containsKey(upStr)) {
                    ret.add(upStr);
                }

                // 현재 숫자에서 -1 (0->9)
                down[i] = down[i] == '0' ? '9' : (char) (down[i] - 1);
                String downStr = new String(down);
                if (!deadEndSet.contains(downStr) && !distMap.containsKey(downStr)) {
                    ret.add(downStr);
                }
            }

            return ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}