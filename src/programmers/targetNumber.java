package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

public class targetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(0, target, true, 0, numbers.length - 1, numbers) + dfs(0, target, false, 0, numbers.length - 1, numbers);
    }

    public int dfs(int tempResult, int goal, boolean isPlus, int currentDepth, int targetDepth, int[] numbers) {
        int newTempResult = isPlus ? tempResult + numbers[currentDepth] : tempResult - numbers[currentDepth];

        if (currentDepth == targetDepth) {
            if (goal == newTempResult) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(newTempResult, goal, true, currentDepth + 1, targetDepth, numbers) + dfs(newTempResult, goal, false, currentDepth + 1, targetDepth, numbers);
    }

}
