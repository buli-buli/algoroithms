package coding.dynamic.medium;

import coding.MyUtil;

/**
 * @author yzw
 * @Description 714、买卖股票的最佳时机含手续费
 * @createTime 2026年02月27日
 */
public class MaxProfitCharge {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }

    static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][prices.length];
        dp[1][0] = -prices[0];

        for (int i = 1; i < prices.length; i++){
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i] - fee);

            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);

            MyUtil.printArray(dp);
        }

        return dp[0][prices.length - 1];
    }
}
