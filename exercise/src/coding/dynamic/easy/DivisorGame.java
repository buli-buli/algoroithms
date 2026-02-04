package coding.dynamic.easy;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 除数博弈
 * @createTime 2026年02月03日
 */
public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(divisorGame(1243312321));
    }

    static boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];

        dp[1] = false;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                if (i % j == 0){
                    if (dp[i - j] == false){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
