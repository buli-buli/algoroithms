package coding.dynamic.medium;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 935、骑士拨号器
 * @createTime 2026年02月27日
 */
public class KnightDialerOptimize {
    public static void main(String[] args) {
//        System.out.println(knightDialer(1));
//        System.out.println(knightDialer(2));
//        System.out.println(knightDialer(3));
//        System.out.println(knightDialer(4));
//        System.out.println(knightDialer(3131));
        System.out.println(knightDialer(3131));
    }

    static int knightDialer(int n) {
        int moves[][] = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        long MOD = 1000000007;
        long dp[] = new long[10];

        for (int i = 0; i < 10; i++){
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++){
            long newDp[] = new long[10];

            for(int j = 0; j < 10; j++){
                for (int k = 0; k < moves[j].length; k++){
                    newDp[j] += dp[moves[j][k]] % MOD;
                }
            }

            dp = newDp;
        }

        long sum = 0;
        for (int i = 0; i < dp.length; i++){
            sum += dp[i];
        }
        long res = sum % MOD;

        return (int) res;
    }
}
