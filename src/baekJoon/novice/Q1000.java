package baekJoon.novice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
A-B
https://www.acmicpc.net/problem/1001
 */
public class Q1000 {
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 버퍼 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력 버퍼 생성
        StringTokenizer st = new StringTokenizer(br.readLine());  // 입력버퍼 라인별로 자름

        Integer a = Integer.valueOf(st.nextToken());        //st.nextToken() -> 공백단위로 리턴
        Integer b = Integer.valueOf(st.nextToken());

        Integer result = a + b;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
