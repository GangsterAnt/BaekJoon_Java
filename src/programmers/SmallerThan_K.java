package programmers;

import java.util.*;

public class SmallerThan_K {
    public static void main(String[] args) {
        SmallerThan_K s = new SmallerThan_K();

//        int solution = s.solution(new int[]{10, 40, 30, 20}, 20);
        int solution = s.solution(new int[]{3,7,2,8,6,4,5,1}, 3);

        System.out.println(solution);
    }
    public int solution(int[] numbers, int k) {
        // BFS를 위한 Queue와 방문 여부를 확인하기 위한 Set
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 초기 상태를 큐에 추가
        q.add(new State(numbers, 0));
        visited.add(Arrays.toString(numbers));

        // BFS 탐색 시작
        while (!q.isEmpty()) {
            State poll = q.poll();
            int[] currentArr = poll.arr;
            int swaps = poll.swaps;

            // 목표 상태와 일치하면 swap 횟수 반환
            if (isValid(currentArr, k)) {
                return swaps;
            }

            // 가능한 모든 swap을 수행
            for (int i = 0; i < numbers.length; i++) {
                for (int ii = i + 1; ii < numbers.length; ii++) {
                    swap(currentArr, i, ii);
                    String currStr = Arrays.toString(currentArr);

                    if (!visited.contains(currStr)) {
                        q.add(new State(currentArr.clone(), swaps + 1));
                        visited.add(currStr);
                    }

                    // swap 원상복구
                    swap(currentArr, i, ii);
                }
            }
        }

        // 조건을 만족할 수 없는 경우 -1 반환
        return -1;
    }

    // 배열 상태를 확인하여 모든 인접한 원소의 차이가 k 이하인지 체크
    private boolean isValid(int[] arr, int k) {
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > k) {
                return false;
            }
        }
        return true;
    }

    // 배열에서 두 인덱스의 원소를 swap
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 상태 클래스 정의
    class State {
        int[] arr;
        int swaps;

        State(int[] arr, int swaps) {
            this.arr = arr;
            this.swaps = swaps;
        }
    }
}

