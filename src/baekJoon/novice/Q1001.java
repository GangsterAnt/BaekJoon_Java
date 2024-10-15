package baekJoon.novice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1001 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer a = Integer.valueOf(st.nextToken());
        Integer b = Integer.valueOf(st.nextToken());

        Integer result = a - b;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();


    }

}
