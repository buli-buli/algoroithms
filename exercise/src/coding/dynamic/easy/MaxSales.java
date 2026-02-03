package coding.dynamic.easy;

/**
 * @author yzw
 * @Description 连续天数的最高销售额
 * @createTime 2026年02月02日
 */
public class MaxSales {
    public static void main(String[] args) {
        System.out.println(maxSales(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSales(new int[]{5,4,-1,7,8}));
        System.out.println(maxSales(new int[]{0}));
        System.out.println(maxSales(new int[]{-1,-2}));
    }
    private static int maxSales(int[] sales) {
        int [] dp = new int[sales.length + 1];

        int max = dp[0] = sales[0];

        for (int i = 1; i < sales.length; i++){
            int tmp = Math.max(dp[i - 1] + sales[i], sales[i]);
            dp[i] = tmp;
            if (tmp > max){
                max = tmp;
            }
        }

        return max;
    }

    private static int doViolent(int[] sales){
        int maxSum = 0;
        for (int i = 0; i < sales.length; i++){
            int sum = 0;

            for (int j = i; j < sales.length; j++){
                sum += sales[j];

                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
