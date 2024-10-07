package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


// https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=problem-list-v2&envId=avihny73
public class InsertDeleteGetRandomBigO1 {

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();

        /*
        ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        [[],[1],[2],[2],[],[1],[2],[]]
         */
//        rs.insert(1);
//        rs.remove(2);
//        rs.insert(2);
//        rs.getRandom();
//        rs.remove(1);
//        rs.insert(2);
//        rs.getRandom();
        /*
        ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        [[],[0],[1],[0],[2],[1],[]]
         */

        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);
        rs.getRandom();
    }
}

class RandomizedSet {
    private Map<Integer, Integer> map; //value, valueList의 index
    private List<Integer> valueList;

    public RandomizedSet() {
        map = new HashMap<>();
        valueList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        valueList.add(val);
        map.put(val, valueList.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        //if this is last element, remove from list and map.
        if (valueList.size() == 1) {
            valueList.remove(0);
            map.remove(val);
            return true;
        }

        //else, need to switch val and last element in the list
        //get list's last info
        int lastIndex = valueList.size() -1;
        int lastValue = valueList.get(lastIndex);
        int valIndex = map.get(val);

        //swap if necessary. val이 리스트의 마지막에 있다면 바꿀 필요가 없다.
        if (valIndex != lastIndex) {
            valueList.set(lastIndex, val);
            valueList.set(valIndex, lastValue);
            map.put(lastValue, valIndex);  //주의. map에서의 인덱스 값도 바꾸어줘야한다.
        }

        //remove val
        valueList.remove(lastIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        if (valueList.size() == 1) {
            return valueList.get(0);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(valueList.size());  //주의 nextInt 는 0 <= x < param 의 값을 리턴한다.
        return valueList.get(randomIndex);
    }
}
