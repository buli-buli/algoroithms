package coding.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yzw
 * @Description 同构字符串
 * @createTime 2024年09月23日
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        IsIsomorphic i = new IsIsomorphic();
        System.out.println(i.isIsomorphic("dada","baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        boolean res = false;

        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            if (sMap.containsKey(sc) && sMap.get(sc) != tc
                || tMap.containsKey(tc) && tMap.get(tc) != sc){
                return false;
            }

            sMap.put(sc, tc);
            tMap.put(tc, sc);
        }

        return true;
    }
}
