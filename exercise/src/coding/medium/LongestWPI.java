package coding.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/14 19:16
 **/
public class LongestWPI {
    public static void main(String[] args) {
        int[] hours = new int[]{5,8,9,9,6,8,7,8};
        System.out.println(longestWPI(hours));
    }

    public static int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();

        int s = 0, res = 0;

        for (int i = 0; i < n; i++){
            s += hours[i] > 8 ? 1 : -1;
            System.out.print("s: " + s + " ");

            if (s > 0){
                res = Math.max(res, i + 1);
            }else {
                if (map.containsKey(s - 1)){
                    res = Math.max(res, i - map.get(s - 1));
                }
            }

            System.out.println("res: " + res);

            if (!map.containsKey(s)){
                map.put(s, i);
            }
        }

        return res;
    }
}
