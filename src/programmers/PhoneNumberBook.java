package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
전화번호 목록

https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumberBook {

    public static void main(String[] args) {
        /*
        ["119", "97674223", "1195524421"]	false
        ["123","456","789"]	true
        ["12","123","1235","567","88"]	false
         */

        PhoneNumberBook phoneNumberBook = new PhoneNumberBook();

        boolean result = false;
        result = phoneNumberBook.solution(new String[]{"119", "97674223", "1195524421"}); // false
        result = phoneNumberBook.solution(new String[]{"123", "456", "789"}); // t
        result = phoneNumberBook.solution(new String[]{"12", "123", "1235", "567", "88"}); // false

        System.out.println("Done");
        return;
    }

    public boolean solution(String[] phone_book) {
        List<String> list = Arrays.asList(phone_book);
        Collections.sort(list);

        String a;
        String b;
        for (int i = 1; i < phone_book.length; ++i) {
            a = list.get(i);
            b = list.get(i - 1);
            if (a.startsWith(b)) {
                return true;
            }
        }

        return false;
    }
}
