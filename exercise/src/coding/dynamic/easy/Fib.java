package coding.dynamic.easy;

/**
 * @author yzw
 * @Description 肥波纳妾数
 * @createTime 2026年02月03日
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }

    static int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int [] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
