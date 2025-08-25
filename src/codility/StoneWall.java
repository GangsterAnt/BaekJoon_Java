package codility;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 * <p>
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 */

import java.util.*;

public class StoneWall {

    public static void main(String[] args) {
        StoneWall stoneWall = new StoneWall();

//        System.out.println(stoneWall.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));

        System.out.println(stoneWall.solution(new int[]{5, 4, 5, 4, 5}));
        System.out.println(stoneWall.solution2(new int[]{5, 4, 5, 4, 5}));
    }

    public int solution(int[] H) {
        Deque<Integer> stack = new LinkedList<>();
        int count = 0;
        for (int h : H) {
            while(!stack.isEmpty() && stack.peekFirst() > h) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peekFirst() < h) {
                count++;
//                System.out.printf("block added H : %d, stack.peek : %d%n", h ,stack.peek());
                stack.push(h);
            }
        }

        return count;
    }

    public int solution2(int[] H) {
        Deque<Integer> stack = new LinkedList<>();

        int count = 1;
        stack.push(H[0]);
        for (int i = 1; i < H.length; ++i) {
//same height. no additional task
            if (H[i] == H[i - 1]) {
                continue;
            } else if (H[i] > H[i - 1]) { //taller
                count++;
                stack.push(H[i]);
                System.out.println("Taller level H[i-1] :" + H[i - 1] + ", H[i] : " + H[i] + ", count : " + count);
            } else { //lower
                while(!stack.isEmpty() && stack.peekFirst() > H[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty() &&stack.peekFirst() == H[i]) {
                    System.out.println("lower level. But hit H[i] :" + H[i] + ", count : " + count);
                    continue;
                }

                count++;
                stack.push(H[i]);
                System.out.println("lower level. But hit not H[i] :" + H[i] + ", count : " + count);
            }
        }

        return count;
    }
}
