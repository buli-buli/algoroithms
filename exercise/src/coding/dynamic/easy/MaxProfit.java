package coding.dynamic.easy;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 121、买卖股票的最佳时机
 * @createTime 2026年02月26日
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2}));
    }

    static int maxProfit(int[] prices) {
        int max = 0;

        int dp[] = new int[prices.length];
        dp[prices.length - 1] = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], prices[i]);
        }

        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(prices));

        for (int i = 0; i < prices.length; i++){
            if (dp[i] - prices[i] > max){
                max = dp[i] - prices[i];
            }
        }

        return max;
    }
}
