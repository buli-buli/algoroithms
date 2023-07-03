package coding.queue.easy;

import javafx.util.Pair;

import java.util.*;

/**
 * @ClassNAME FirstUniqChar
 * @Description 字符串中的第一个唯一字符
 * @Author yu
 * @Date 2023/6/30 17:07
 * @Version 1.0
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqChar f = new FirstUniqChar();
        System.out.println(f.firstUniqChar(s));
    }
    public int firstUniqChar(String s) {
        Map<Character, Integer> cMap = new HashMap<>();
        Queue<Pair<Character, Integer>> cQueue = new LinkedList<>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if (!cMap.containsKey(c)){
                cMap.put(c, i);
                cQueue.add(new Pair(c, i));
            }else {
                cMap.put(c, -1);
                while(null != cQueue.peek() && cMap.get(cQueue.peek().getKey()) == -1){
                    cQueue.poll();
                }
            }

            i++;
        }
        if (null == cQueue.peek()){
            return -1;
        }
        return cQueue.peek().getValue();
    }
}
