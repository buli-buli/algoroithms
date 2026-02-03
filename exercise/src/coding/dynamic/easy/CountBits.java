package coding.dynamic.easy;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author yzw
 * @Description 比特位计数
 * @createTime 2026年02月03日
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(0)));
        System.out.println(Arrays.toString(countBits(1)));
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(3)));
    }

    private static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++){
            if (i % 2 == 0){
                dp[i] = dp[i / 2];
            }else {
                dp[i] = dp[i / 2] + 1;
            }
        }

        return dp;
    }

    public int[] doViolent(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++){
            String b = Integer.toBinaryString(i);
            res[i] = b.length() - b.replace("1", "").length();
        }
        return res;
    }
}
