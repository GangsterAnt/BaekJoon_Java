package hackerRank.oneWeekPreparation;

public class PalindromeIndex {
    public static int palindromeIndex(String s) {
        // Write your code here
        int left = 0;
        int right = s.length() -1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                //왜 더 안보는가? -> 1개 다른걸빼서 팰린드롬이 아니면 어차피 1개 뺴서 만들수 있는 펠린드롬이 아니다
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                } else if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                break;
            }
        }
        return -1;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
