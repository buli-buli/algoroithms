package coding.dynamic.easy;

/**
 * @author yzw
 * @Description 跳跃训练
 * @createTime 2026年02月03日
 */
public class TrainWays {

    public static void main(String[] args) {
        System.out.println(trainWays(100));
    }

    private static int trainWays(int num) {
        if (num < 2){
            return 1;
        }
        int [] dp = new int[num + 1];
        int mod = 1000000007;

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= num; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[num];
    }
}
