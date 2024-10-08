import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.valueOf(br.readLine());
        List<Integer> itemList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemList.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(itemList);

        for (int i =0; i< n; i++) {
            bw.write(itemList.get(i).toString() + '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }


}
