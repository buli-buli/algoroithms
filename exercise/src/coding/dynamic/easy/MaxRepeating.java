package coding.dynamic.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yzw
 * @Description 最大重复子字符串
 * @createTime 2026年02月03日
 */
public class MaxRepeating {
    public static void main(String[] args) {
//        System.out.println(maxRepeating("a", "a"));
//        System.out.println(maxRepeating("ababc", "ac"));
//        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
//        System.out.println(maxRepeating("baba", "b"));
    }

    static int maxRepeating(String sequence, String word) {
        int dp[] = new int[sequence.length() + 1];

        int maxK = 0;

        int m = word.length();

        for (int i = m; i <= sequence.length(); i++){
            String tmp = sequence.substring(i - m, i);
            if (tmp.equals(word)){
                dp[i] = dp[i - m] + 1;
            }else {
                dp[i] = 0;
            }
            if (dp[i] > maxK){
                maxK = dp[i];
            }

            System.out.println((i-m) + ", " + i + ": " + tmp);
        }

        System.out.println(Arrays.toString(dp));

        return maxK;
    }

    static int violent(String sequence, String word) {
        int maxK = 0;
        for (int k = 0; k <= sequence.length(); k++){
            String tmp = giao(word, k);
            if (sequence.contains(tmp)){
                maxK = Math.max(maxK, k);
            }
        }

        return maxK;
    }

    static String giao(String s, int k){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++){
            sb.append(s);
        }

        return sb.toString();
    }
}
