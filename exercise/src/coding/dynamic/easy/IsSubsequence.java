package coding.dynamic.easy;

import coding.MyUtil;
import com.sun.deploy.util.StringUtils;

/**
 * @author yzw
 * @Description 判断子序列
 * @createTime 2026年02月03日
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("", "ahbgdc"));
    }
    static boolean isSubsequence(String s, String t) {
        if ("".equals(s)){
            return true;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }

                if (dp[i][j] == s.length()){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean doublePointer(String s, String t) {
        int sFlag = 0;
        int tFlag = 0;

        while (tFlag < t.length() && sFlag < s.length()){
            if (s.charAt(sFlag) == t.charAt(tFlag)){
                sFlag++;
                tFlag++;
            }else {
                tFlag++;
            }
        }

        return sFlag == s.length();
    }
}
