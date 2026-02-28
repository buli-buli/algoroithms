package coding.dynamic.medium;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 935、骑士拨号器
 * @createTime 2026年02月27日
 */
public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
        System.out.println(knightDialer(4));
        System.out.println(knightDialer(3131));
    }

    static int knightDialer(int n) {
        int moves[][] = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        long MOD = 1000000007;
        long dp[][] = new long[n + 1][10];

        for (int i = 0; i < 10; i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < 10; j++){
                for (int k = 0; k < moves[j].length; k++){
                    dp[i][j] += dp[i-1][moves[j][k]] % MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < dp[n-1].length; i++){
            sum += dp[n-1][i];
        }
        long res = sum % MOD;

        return (int) res;
    }
}
