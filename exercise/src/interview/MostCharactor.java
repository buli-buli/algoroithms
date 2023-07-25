package interview;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNAME MostCharactor
 * @Description 找出字符串中出现次数最多的字符及出现次数
 * @Author yu
 * @Date 2023/7/17 16:48
 * @Version 1.0
 */
public class MostCharactor {
    public static void main(String[] args) {

        String s = "System.out.println()";

        MostCharactor m = new MostCharactor();
        Pair resPair = m.getMost(s);
        System.out.println("字符：" + resPair.getKey() + ", 次数：" + resPair.getValue());
    }

    public Pair getMost(String s){
        char[] chars = s.toCharArray();

        Map<Character, Integer> cMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char c = chars[i];

            if (!cMap.containsKey(c)){
                cMap.put(c, 1);
            }else {
                cMap.put(c, cMap.get(c) + 1);
            }
        }

        Character res = null;
        Integer max = -1;

        for (Character c : cMap.keySet()){
            if (cMap.containsKey(c) && cMap.get(c) > max){
                res = c;
                max = cMap.get(c);
            }
        }

        Pair<Character, Integer> resPair = new Pair<>(res, max);
        return resPair;
    }
}
