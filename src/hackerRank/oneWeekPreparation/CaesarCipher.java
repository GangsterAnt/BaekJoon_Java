package hackerRank.oneWeekPreparation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CaesarCipher {
    public static String caesarCipher(String s, int k) {
        // Write your code here
        Map<Character, Character> map = new HashMap<>();
        char key;
        char value;
        k = k % 26;
        for (int i = 0; i < 26; ++i) {
            key = (char) ('a' + i);
            value = (char) ('a' + i + k);
            if (value > 'z') {
                value -= 26;
            }
            map.put(key, value);

            key = (char) ('A' + i);
            value = (char) ('A' + i + k);
            if (value > 'Z') {
                value -= 26;
            }
            map.put(key, value);
        }
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String s = bufferedReader.readLine();

            int k = Integer.parseInt(bufferedReader.readLine().trim());

            String result = CaesarCipher.caesarCipher(s, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
