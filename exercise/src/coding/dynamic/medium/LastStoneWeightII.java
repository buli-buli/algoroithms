package coding.dynamic.medium;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 1049、最后一块石头的重量 Ⅱ
 * @createTime 2026年02月25日
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40}));
    }

    static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++){
            sum+= stones[i];
        }

        if (sum == 0){
            return 0;
        }

        int target = sum >> 1;

        boolean [] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < stones.length; i++){
            for (int j = target; j >= stones[i]; j--){
                dp[j] = dp[j] || dp[j - stones[i]];
            }
        }

        //System.out.println(Arrays.toString(dp));
        for (int i = target; i >= 0; i--){
            if (dp[i]){
                return sum - (i * 2);
            }
        }

        return 0;
    }
}
