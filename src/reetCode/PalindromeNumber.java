package reetCode;


/*
    https://leetcode.com/problems/palindrome-number/description/?envType=problem-list-v2&envId=anpvdfzi
 */
public class PalindromeNumber {

    //using string.
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String input = Integer.valueOf(x).toString();

        for (int i = 0; i < input.length() / 2; ++i) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    //using Integer only
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int a = x;
        int b = 0;

        while (a > 0) {
            b = 10 * b;
            b += a % 10;
            a = a / 10;
        }

        return b == x;
    }
}
