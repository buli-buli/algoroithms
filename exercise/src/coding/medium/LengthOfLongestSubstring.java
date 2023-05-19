package coding.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassNAME LengthOfLongestSubstring
 * @Description 无重复字符的最长子串
 * @Author yu
 * @Date 2023/5/11 14:29
 * @Version 1.0
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        //最长子串结束下标
        int end = 0;
        int begin = 0;
        int count = 0;
        int max = 0;

        HashSet<Character> cMap = new HashSet<>();
        while (end < s.length()){
            char c = s.charAt(end);

            if (!cMap.contains(c)){
                end++;
                count++;
                cMap.add(c);
                max = Math.max(count, max);
            }else {
                cMap.remove(s.charAt(begin));
                begin++;
                count --;
            }

        }

        return max;
    }
}
