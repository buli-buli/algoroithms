package coding.linklist.medium;

import java.util.*;

/**
 * @ClassNAME GroupAnagrams
 * @Description 字母异位词分组
 * @Author yu
 * @Date 2023/8/10 16:18
 * @Version 1.0
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int i = 0;
        while (i < strs.length){
            String s = strs[i];
            System.out.print("s: " + s + ", ");
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = String.valueOf(chars);
            System.out.println("s1: " + s1);
            List<String> element;
            if (map.containsKey(s1)){
                element = map.get(s1);
                element.add(s);
                map.put(s1, element);
            }else {
                element = new ArrayList<>();
                element.add(s);
                map.put(s1, element);
            }
            i++;
        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}
