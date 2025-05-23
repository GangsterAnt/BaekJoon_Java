package groom;

import java.io.*;
import java.util.*;

public class MeetingPlaceTwo {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static StringBuilder sb;

    static int n;
    static List<Integer> xList;
    static List<Integer> yList;

    public static void main(String[] args) throws Exception {
        init();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int y;
        int x;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            yList.add(y);
            x = Integer.parseInt(st.nextToken());
            xList.add(x);
        }

        Collections.sort(xList);
        Collections.sort(yList);

        x = xList.get( xList.size()/2);
        y = yList.get(yList.size() /2);
        sb.append(y);
        sb.append(" ");
        sb.append(x);
        bw.write(sb.toString());
        close();
    }

    private static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xList = new ArrayList<>();
        yList = new ArrayList<>();
        sb = new StringBuilder();
    }

    private static void close() throws Exception{
        br.close();
        bw.flush();
        bw.close();
    }
}
