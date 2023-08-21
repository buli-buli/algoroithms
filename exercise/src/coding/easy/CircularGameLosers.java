package coding.easy;

import java.util.*;

/**
 * @ClassNAME CircularGameLosers
 * @Description 找出转圈游戏输家
 * @Author yu
 * @Date 2023/8/16 9:55
 * @Version 1.0
 */
public class CircularGameLosers {
    public static void main(String[] args) {
        CircularGameLosers c = new CircularGameLosers();
        System.out.println(Arrays.toString(c.circularGameLosers(5,2)));
    }
    public int[] circularGameLosers(int n, int k) {
        if (n == 1){
            return new int[]{};
        }
        int round = 0, passBy = 1, count = 0;
        boolean end = false;
        Map<Integer, Integer> map = new HashMap<>();
        while (!end){
            passBy = (passBy + round * k) % n;
            if (passBy == 0){
                passBy = n;
            }
            int time = map.getOrDefault(passBy, 0);
            time+=1;
            if (time == 1){
                count ++;
            }
            map.put(passBy, time);
            if (time >= 2){
                end = true;
            }

            round++;
        }

        int[] ans = new int[n - count];
        int flag = 0;
        for (int i = 1; i <= n; i++){
            if (!map.containsKey(i)){
                ans[flag++] = i;
            }
        }

        return ans;
    }
}
