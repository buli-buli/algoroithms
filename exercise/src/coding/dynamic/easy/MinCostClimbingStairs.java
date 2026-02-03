package coding.dynamic.easy;

/**
 * @author yzw
 * @Description 爬楼梯
 * @createTime 2026年02月02日
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20,1,100,1,1,100,1,1,1}));
    }
    private static int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length + 1];


        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
