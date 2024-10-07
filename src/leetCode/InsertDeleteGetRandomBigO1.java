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

/*
     Hashset, HashMap 의 put,contain, remove 등등은 해시값을 이용하므로 O(1)
     arrayList의 인덱스 접근은 O(1), 삭제는 O(n)이지만 "마지막원소의 삭제" 는 O(1) 이므로.
     현재 맵에 있는 원소들을 리스트에 넣자, 이때 key는 전달받은 값, 리스트의 인덱스 값을 value로 맵에 넣는다.

     put은 맵과 리스트에 둘다 넣는다.

     remove는 val과 list의 마지막 원소와 자리를 바꿔친다.
     (이떄 리스트와 맵에서 모두 값을 바꿔쳐야함) #89~#92 참조

     이후 맵과 리스트에서 모두 삭제한다.

     랜덤은 리스트에서 랜덤하게 인덱스 뽑아서 리턴한다.
 */

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
