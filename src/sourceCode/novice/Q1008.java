package sourceCode.novice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1008 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Double a, b;
        a = Double.valueOf(st.nextToken());
        b = Double.valueOf(st.nextToken());


        String resultString = String.format("%.9f", a / b);

        bw.write(resultString);
        br.close();
        bw.flush();
        bw.close();
    }
}
