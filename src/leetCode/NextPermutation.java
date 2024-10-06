package leetCode;

// https://leetcode.com/problems/next-permutation/description/?envType=problem-list-v2&envId=avihny73
public class NextPermutation {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3};
//        int[] nums = new int[]{3, 2, 1};
        int[] nums = new int[]{1,3,2};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /*
        전략 :
        1,2,3,4,5 를
        5,4,3,2,1 로 바꿔가는 과정이라고 생각하자. (내림차순 정렬)

        다음 순번을 알아내는 법은 뒤에서부터 조금씩 바꿔가는것.
        어떻게? 맨뒤에서부터 점진적으로 오름차순으로 정렬하는것. (그러면 순열은 정방향으로 봤을때 내림차순 정렬이 되는것 처럼 보인다)

        step1) 뒤에서부터 선형 탐색, 뒤에서 순열을 보는것을 기준으로 오름차순이 아니게 되는 첫 부분을 찾는다.
        i.e) 1,3,4,5,2 는 거꾸로 보면 "4,5" 부분이 뒤에서 봤을때 오름차순이 아니다. 고로 이부분이 변경되어야한다.
        그렇다면 무엇과 변경되어야하는가? 4 보다 뒤에있는 원소중에 4보다 큰 값중 가작 작은값이 되어야한다.
        왜냐하면.. 사전순으로 정렬하기 위해서는  1,3,4,5,2 보다 큰 값이 4의 자리에 와야한다. (2가 온다면 1,3,2,5,4 가 되므로 사전순으로 더 앞에 오는 순열이 생성된다)
        그러므로 순열은 swap 연산후 1,3,5,4,2 가 된다.

        step2) 1,3,4,5,2 의 부분순열 5,2 는 내림차순이었으나 4가 5로 변경되면서 부분순열은 오름차순이 되어야 한다.
        swap을 통해 1,3,4,XX 가 1,3,5,x,x가 되면서 1,3,5를 prefix로 갖는 가장 작은 순열이 되어야한다.
        그러므로 x,x 부분은 가지고있는 모든원소들이 가장 빠른 사전순서 (오름차순) 을 가져야한다.
     */

    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int targetIndex = -1;

        //get index that breaks descending order from back of list.
        for (int i = size - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                targetIndex = i - 1;
                break;
            }
        }

        if (targetIndex == -1) { // if given list is last permutation.
            //reverse whole list and return it
            reverseList(nums, 0, size - 1);
            return;
        }

        //swap targetIndex and  smallest element that satisfy nums[targetIndex] < nums[i] (  targetIndex < i < size )
        findNextSmallestElementAndSwapIt(nums, targetIndex);
        //reverse whole array from nums[targetIndex+1] ~ nums[size -1]
        reverseList(nums, targetIndex + 1, size - 1);
    }

    private void findNextSmallestElementAndSwapIt(int[] nums, int targetIndex) {
        int smallestNextElement = Integer.MAX_VALUE;
        int smallestNextIndex = -1;
        for (int i = nums.length - 1; i > targetIndex; --i) {
            if (nums[i] < smallestNextElement && nums[i] > nums[targetIndex]) {
                smallestNextElement = nums[i];
                smallestNextIndex = i;
            }
        }

        swap(nums, targetIndex, smallestNextIndex);
    }


    private void reverseList(int[] nums, int from, int to) {
        while(from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
