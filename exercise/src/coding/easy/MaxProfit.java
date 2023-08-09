package coding.easy;

/**
 * @ClassNAME MaxProfit
 * @Description 买卖股票的最佳时机
 * @Author yu
 * @Date 2023/8/7 17:08
 * @Version 1.0
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{2,4,1};

        MaxProfit m = new MaxProfit();
        System.out.println(m.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int minPrice = 1000000;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
