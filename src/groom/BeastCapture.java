package groom;

import java.io.*;
import java.util.*;

/*
https://level.goorm.io/exam/355197/%EB%A7%B9%EC%88%98-%ED%8F%AC%ED%9A%8D/quiz/1


 */
public class BeastCapture {

    static int bx, by;
    static int gx, gy;
    static int n;

    static List<Integer> xList;
    static List<Integer> yList;

    static String YES = "YES";
    static String NO = "NO";

    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        init();
        int dist = (bx - gx) * (bx - gx) + (by - gy) * (by - gy);
        if (dist < 25 || n < 3) {
            close(NO);
            return;
        }

        int yMin = (by < gy) ? by : gy;
        int yMax = (by < gy) ? gy : by;

        int xMin = (bx < gx) ? bx : gx;
        int xMax = (bx < gx) ? gx : bx;

        int trapInRec = 0;
        int trapX;
        int trapY;
        for (int i = 0; i < n; ++i) {
            trapY = yList.get(i);
            trapX = xList.get(i);
            if (trapX >= xMin && trapX <= xMax && trapY >= yMin && trapY <= yMax) {
                trapInRec++;
            }
        }

        if (trapInRec >= 3) {
            close(YES);
            return;
        }
        close(NO);
        return;
    }

    private static void close(String result) throws Exception {
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();

        List<int[]> hello;
    }

    private static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        bx = Integer.parseInt(st.nextToken());
        by = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        gx = Integer.parseInt(st.nextToken());
        gy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        xList = new ArrayList<>();
        yList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(st.nextToken()));
            yList.add(Integer.parseInt(st.nextToken()));
        }
    }
}
