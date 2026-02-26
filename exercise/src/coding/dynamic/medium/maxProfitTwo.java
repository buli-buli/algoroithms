package coding.dynamic.medium;

import coding.MyUtil;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 122、买卖股票的最佳时机 Ⅱ
 * @createTime 2026年02月26日
 */
public class maxProfitTwo {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    static int maxProfit(int[] prices) {

        int[][] dp = new int[2][prices.length];
        dp[1][0] = -prices[0];

        for (int i = 1; i < prices.length; i++){
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);

            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);

            MyUtil.printArray(dp);
        }

        return dp[0][prices.length - 1];
    }
}
