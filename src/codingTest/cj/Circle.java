package codingTest.cj;


import java.util.Arrays;

public class Circle {

    /*
    좌표 평면상에 n개의 원이 있다.
    이 원들중에서 다음조건을 만족시키면서 최대한 많은 원을 고르고자 한다

    - 고른 원들중 임의의 2개의 원을 선택했을때, 한 원이 다른 원안에 반드시 포함되어야 한다
    - 둘중 한 원이 다른 원을 벗어나지 않고, 내부에 존재하면 포함된다고 정의한다 이때 두 원이 한점에서 만나더라도 포함한다고 간주한다.

    원들의 중심좌표와 반지름 정보가 담긴 2차원 정수 배열 circles가 주어진다
    위의 조건을 만족하며 circles에서 선택할 수 있는 원의 최대 개수를 return하는 함수 solution을 작성하라
    포함관계에 있는 원의 쌍이 하나도 없을경우 1을 리턴한다.

    제한사항
    2 <= circles의 길이 <= 100
    circles의 원소는 [x, y, r] 형태로 이루어져 있으며, x, y는 원의 중심 좌표, r은 반지름을 의미한다
    -10^9 <= x, y <= 10^9
    1<= r <= 10^9
    중심과 반지름이 동시에 같은 원은 존재하지 않는다

    10초, 2gb 메모리 제한

    예
    [[-4,0,2],[-4,0,4],[-4,0,6],[2,0,8]] -> 3
    [[1,0,2],[-1,0,2]] -> 1
     */

    public static void main(String[] args) {
        Circle circle = new Circle();
        int[][] circles1 = new int[][]{{-4, 0, 2}, {-4, 0, 4}, {-4, 0, 6}, {2, 0, 8}};
        int[][] circles2 = new int[][]{{1, 0, 2}, {-1, 0, 2}};
        System.out.println(circle.solution(circles1)); //3
        System.out.println(circle.solution(circles2)); //1
    }

    int currentInnerCircles;
    int answer;
    int length;

    int baseX;
    int baseY;
    int baseR;

    int targetX;
    int targetY;
    int targetR;

    boolean[] visited;

    public int solution(int[][] circles) {
        init (circles);
        //방문처리를 하므로써 O(n^2) -> O(nlog(n))
        for (int i =0; i< length; ++i) {
            if (visited[i]) continue; // 이미 방문한 원은 건너뛴다
            visited[i] = true; // 현재 원을 방문처리
            for (int j = i + 1; j<length; ++ j) {
                if (visited[j]) continue; // 이미 방문한 원은 건너뛴다
                visited[i] = true; // 현재 원을 방문처리
                baseX = circles[i][0];
                baseY = circles[i][1];
                baseR = circles[i][2];

                targetX = circles[j][0];
                targetY = circles[j][1];
                targetR = circles[j][2];

                if (isContainedCircle()) {
                    currentInnerCircles++;
                }
                answer = Math.max(answer, currentInnerCircles);
            }
            currentInnerCircles = 1;
        }

        return answer;
    }

    private boolean isContainedCircle() {
        return (baseX - targetX) * (baseX - targetX) + (baseY - targetY) * (baseY - targetY) <= (baseR - targetR) * (baseR - targetR);
    }

    private void init(int[][] circles) {
        length = circles.length;
        answer = 1;
        currentInnerCircles = 1;
        Arrays.sort(circles,(a, b) -> Integer.compare(b[2],a[2])); // 반지름기준 내림차 정렬
        visited = new boolean[length];
    }
}
