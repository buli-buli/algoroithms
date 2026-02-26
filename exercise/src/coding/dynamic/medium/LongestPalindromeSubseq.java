package coding.dynamic.medium;

import coding.MyUtil;

/**
 * @author yzw
 * @Description 516、最长回文子序列
 * @createTime 2026年02月26日
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    static int longestPalindromeSubseq(String s) {
        int max = 1;

        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }

        for (int n = 2; n <= s.length(); n++){
            for (int i = 0; i < s.length() - n + 1; i++){
                int j = i + n - 1;
                if (s.charAt(i) == s.charAt(j)){
                    if (n == 2){
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }

        //MyUtil.printArray(dp);

        return max;
    }
}
