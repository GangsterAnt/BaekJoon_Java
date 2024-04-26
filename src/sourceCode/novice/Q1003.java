package sourceCode.novice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/*
피보나치
https://www.acmicpc.net/problem/1003
 */
public class Q1003 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long fibonazziNumber;

        long lineSize = Long.valueOf(br.readLine());
        for (int index = 0; index < lineSize; ++index) {
            st = new StringTokenizer(br.readLine());
            fibonazziNumber = Long.valueOf(st.nextToken());
            bw.write(fibonazzi(fibonazziNumber));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private int fibonazzi(long num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }
        return fibonazzi(num - 1) + fibonazzi(num - 2);
    }
}
