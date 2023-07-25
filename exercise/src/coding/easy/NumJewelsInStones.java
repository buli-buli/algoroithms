package coding.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassNAME NumJewelsInStones
 * @Description 宝石与石头
 * @Author yu
 * @Date 2023/7/24 10:30
 * @Version 1.0
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jSet = new HashSet<>();
        int res = 0;

        for (int i = 0; i < jewels.length(); i++){
            jSet.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++){
            Character c = stones.charAt(i);
            if (jSet.contains(c)){
                res++;
            }
        }

        return res;
    }
}
