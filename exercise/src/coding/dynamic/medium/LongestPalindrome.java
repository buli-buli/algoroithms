package coding.dynamic.medium;

/**
 * @author yzw
 * @Description 5、最长回文子串
 * @createTime 2026年02月26日
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    static String longestPalindrome(String s) {
        String res = s.substring(0, 1);

        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }

        for (int n = 2; n <= s.length(); n++){
            for (int i = 0; i < s.length() - n + 1; i++){
                int j = i + n - 1;
                //System.out.println(i + ", " + j);
                if (s.charAt(i) == s.charAt(j)){
                    if (n == 2){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if (dp[i][j]){
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
