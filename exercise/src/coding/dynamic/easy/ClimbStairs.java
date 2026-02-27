package coding.dynamic.easy;

/**
 * @author yzw
 * @Description 70、爬楼梯
 * @createTime 2026年02月27日
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    static int climbStairs(int n) {
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
