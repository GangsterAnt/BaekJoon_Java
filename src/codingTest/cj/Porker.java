package codingTest.cj;

import java.util.*;

public class Porker {

    /*
    1이상 9 이하의 숫자가 적혀있고 숫자색이 검은색, 빨간색인 카드가 1장씩 18장으로 구성되어 있습니다.

    카드 3장으로 이뤄진 패는 4가지 족보 top, pair, stright, stright flush 가 있다.

    top: 가장 높은 숫자
    pair: 같은 숫자가 2장 있는 패
    stright: 숫자가 연속으로 3장 있는 패
    stright flush: 숫자가 연속으로 3장 있는 패 중에서 색이 모두 같은 패
     */

    public static void main(String[] args) {
        Porker p = new Porker();
        String[] cards = new String[]{"1r", "9b", "9r"};
        String[] result = p.solution(cards);
        System.out.println(Arrays.toString(result));
    }


    static final String[] LOSE = new String[]{"lose"};
    String myHand;
    String opponentHand;
    String sharedCard;
    Map<String, Boolean> cardDeck;
    List<String> answerList;

    static final String[] deck = new String[]{
            "1b", "2b", "3b", "4b", "5b", "6b", "7b", "8b", "9b",
            "1r", "2r", "3r", "4r", "5r", "6r", "7r", "8r", "9r"
    };

    Character tempNum1;
    Character tempNum2;
    Character tempNum3;

    Character[] tempNumList;

    Character tempColor1;
    Character tempColor2;
    Character tempColor3;


    public String[] solution(String[] cards) {
        init(cards);
        dfs();
        if (answerList.isEmpty()) {
            return LOSE;
        } else {
            Collections.sort(answerList);
            String[] answer = new String[answerList.size()];
            for (int i = 0; i < answerList.size(); ++i) {
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    }

    private void dfs() {
        for (String s : deck) {
            if (cardDeck.get(s)) continue; // 이미 사용된 카드면 skip
            if (winnerIsMe(s)) {
                answerList.add(s);
            }
        }
    }

    private boolean winnerIsMe(String s) {
        int myScore = getScore(myHand, sharedCard, s);
        int opponentScore = getScore(opponentHand, sharedCard, s);
        if (myScore > opponentScore) {
            return true;
        } else if (myScore == opponentScore) {
            // 동점일 경우, 숫자가 더 큰 쪽이 승리
            if (myHand.charAt(0) > opponentHand.charAt(0)) {
                return true;
            } else if (myHand.charAt(0) == opponentHand.charAt(0) && myHand.charAt(1) == 'r'){ // 동점이면서 숫자가 같을 경우 빨간카드가 승리
                return true;
            }
        }
        return false;
    }

    //top = 1, pair = 2, stright = 3, stright flush = 4
    private int getScore(String hand, String shared, String target) {
        tempNum1 = hand.charAt(0); // 숫자
        tempColor1 = hand.charAt(1); // 색깔

        tempNum2 = shared.charAt(0); // 숫자
        tempColor2 = shared.charAt(1); // 색깔

        tempNum3 = target.charAt(0); // 숫자
        tempColor3 = target.charAt(1); // 색깔

        tempNumList[0] = tempNum1;
        tempNumList[1] = tempNum2;
        tempNumList[2] = tempNum3;
        Arrays.sort(tempNumList);

        if (isStright()) {
            if(isFlush()) {
                return 4;
            }
            return 3;
        } else if(isPair()) {
            return 2;
        } else {
            return 1; // top
        }
    }

    private boolean isStright() {
        return tempNumList[0] + 1 == tempNumList[1] && tempNumList[1] + 1 == tempNumList[2];
    }

    private boolean isFlush() {
        return tempColor1 == tempColor2 && tempColor2 == tempColor3;
    }

    private boolean isPair() {
        return tempNum1 == tempNum2 || tempNum1 == tempNum3 || tempNum2 == tempNum3;
    }

    private void init(String[] cards) {
        answerList = new ArrayList<>();
        tempNumList = new Character[3];
        myHand = cards[0];
        opponentHand = cards[1];
        sharedCard = cards[2];
        cardDeck = new HashMap<>();
        for (String s : deck) {
            cardDeck.put(s, false);
        }

        cardDeck.put(cards[0], true);
        cardDeck.put(cards[1], true);
        cardDeck.put(cards[2], true);
    }

}
