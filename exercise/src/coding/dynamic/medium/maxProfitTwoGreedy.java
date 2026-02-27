package coding.dynamic.medium;

import coding.MyUtil;

/**
 * @author yzw
 * @Description 122、买卖股票的最佳时机 Ⅱ
 * @createTime 2026年02月26日
 */
public class maxProfitTwoGreedy {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    static int maxProfit(int[] prices) {

        int sum = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }

        return sum;
    }
}
