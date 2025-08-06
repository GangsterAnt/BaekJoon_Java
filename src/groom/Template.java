package groom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;
import java.util.stream.Collectors;

public class Template {
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw;

    private static Comparator<Map.Entry<String, List<Integer>>> sortList =
            (s1, s2) -> {
                if (s1.getValue().size() < s2.getValue().size()) {
                    return 1;
                } else if (s1.getValue().size() == s2.getValue().size()) {
                    return 0;
                }

                return -1;
            };

    private static void comparatorExampe() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Map.Entry<String, List<Integer>>> sortedList = map.entrySet().stream().sorted(sortList).collect(Collectors.toList());

    }

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
