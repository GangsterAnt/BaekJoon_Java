package groom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Template {
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        init();

        close();
    }

    private static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
    }

    private static void close() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }
}
