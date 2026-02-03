package coding.bzc;

/**
 * @author yzw
 * @Description 第n个泰波那契数
 * @createTime 2026年02月03日
 */
public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(0));
    }

    static int tribonacci(int n) {
        int [] dp = new int[n + 1];

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
