package coding.dynamic.medium;

import coding.MyUtil;

/**
 * @author yzw
 * @Description 最长公共子序列
 * @createTime 2026年02月25日
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
        System.out.println(longestCommonSubsequence("bl", "yby"));
    }

    static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length() + 1][text2.length() + 1];

        char [] ch1 = text1.toCharArray();
        char [] ch2 = text2.toCharArray();

        //MyUtil.printArray(dp);

        for (int i = 1; i <= ch1.length; i++){
            for (int j = 1; j <= ch2.length; j++){
                if (ch1[i - 1] == ch2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //MyUtil.printArray(dp);

        return dp[ch1.length][ch2.length];
    }
}
