package hackerRank.oneWeekPreparation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion {


    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    /*
    솔룬션
    public static String timeConversion(String s) {
    String period = s.substring(s.length() - 2); // AM or PM
    String[] time = s.substring(0, 8).split(":"); // [hh, mm, ss]

    int hour = Integer.parseInt(time[0]);

    if (period.equals("AM")) {
        if (hour == 12) hour = 0;
    } else { // PM
        if (hour != 12) hour += 12;
    }

    return String.format("%02d:%s:%s", hour, time[1], time[2]);
}
     */
    public static String timeConversion(String s) {
        // Write your code here
        String[] split;
        String[] time;
        if (s.contains("PM")) {
            split = s.split("PM");
            time = split[0].split(":");
            int hour = Integer.parseInt(time[0]);
            if (hour == 12) {
                return hour + ":" + time[1] + ":"+ time[2];
            }
            return (hour + 12) + ":" + time[1] + ":"+ time[2];
        } else {
            split = s.split("AM");
            time = split[0].split(":");
            if (split[0].startsWith("12")) {
                return "00:" + time[1] + ":"+ time[2];
            }
            return split[0];
        }
    }

    public static String timeConversion2(String s) {
        // Write your code here
       String amPm = s.substring(s.length() - 2);
       String[] time = s.substring(0, s.length()-2).split(":");
       int hour = Integer.parseInt(time[0]);
       if (amPm.equals("AM")) {
           if (hour == 12) {
               hour = 0;
           }
           return  String.format("%02d:%s:%s", hour, time[1], time[2]);
       } else {
           if (hour != 12) {
               hour += 12;
           }
       }
        return  String.format("%02d:%s:%s", hour, time[1], time[2]);
    }

    private static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = bufferedReader.readLine();

            String result = TimeConversion.timeConversion(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}



