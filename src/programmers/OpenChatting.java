package programmers;

import java.util.*;

public class OpenChatting {

    private static final String ENTER_MSG = "%s님이 들어왔습니다.";
    private static final String LEAVE_MSG = "%s님이 나갔습니다.";

    public String[] solution(String[] record) {

        Map<String, String> userMap = new HashMap<>();
        List<String> enterAndLeave = new ArrayList<>();

        for (int i = 0; i < record.length; ++i) {
            String[] split = record[i].split(" ");

            //if enter leave commend, add it to record.
            if ("Enter".equals(split[0]) || "Leave".equals(split[0])) {
                enterAndLeave.add(record[i]);
            }
            if (!"Leave".equals(split[0])) {
                userMap.put(split[1], split[2]);
            }
        }

        String[] answer = new String[enterAndLeave.size()];

        for (int i = 0; i < enterAndLeave.size(); ++i) {
            String[] split = enterAndLeave.get(i).split(" ");
            if ("Enter".equals(split[0])) {
                answer[i] = String.format(ENTER_MSG, userMap.get(split[1]));
            } else if ("Leave".equals(split[0])) {
                answer[i] = String.format(LEAVE_MSG, userMap.get(split[1]));
            }
        }

        return answer;
    }
}
