package baekJoon.dp;

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
    public static int[] fiboDpArray = new int[42];

    public static final String SPACE = " ";

    public void solution() throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long lineSize = Long.parseLong(br.readLine());


        for (int index = 0; index < lineSize; ++index) {
            st = new StringTokenizer(br.readLine());
            int fiboNum = Integer.parseInt(st.nextToken());
            sb.append(fiboDpArray[fiboNum]).append(SPACE).append(fiboDpArray[fiboNum + 1]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void init() {
        fiboDpArray[0] = 1;
        fiboDpArray[1] = 0;
        for (int i = 2; i < 42; ++i) {
            fiboDpArray[i] = fiboDpArray[i - 1] + fiboDpArray[i - 2];
        }
    }
}
