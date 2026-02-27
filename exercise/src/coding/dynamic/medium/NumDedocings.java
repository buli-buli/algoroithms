package coding.dynamic.medium;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 91、解码方法
 * @createTime 2026年02月27日
 */
public class NumDedocings {
    public static void main(String[] args) {
//        System.out.println(numDecodings("12"));
//        System.out.println(numDecodings("226"));
//        System.out.println(numDecodings("27"));
//        System.out.println(numDecodings("06"));
//        System.out.println(numDecodings("2102"));
//        System.out.println(numDecodings("1123"));
//        System.out.println(numDecodings("10011"));
//        System.out.println(numDecodings("2611055971756562"));
//        System.out.println(numDecodings("1201234"));
//        System.out.println(numDecodings("207"));
//        System.out.println(numDecodings("301"));
//        System.out.println(numDecodings("99"));
        System.out.println(numDecodings(null));
    }

    static int numDecodings(String s) {
        if (null == s){
            return 0;
        }
        if (s.length() == 1){
            if (s.charAt(0) == '0'){
                return 0;
            }

            return 1;
        }

        if (s.charAt(0) == '0'){
            return 0;
        }

        int[] dp = new int[s.length()];

        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) > 10 && Integer.parseInt(s.substring(0, 2)) <= 26 && s.charAt(1) != '0'){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }

        if (s.charAt(1) == '0' && s.charAt(0) > '2'){
            return 0;
        }

        for (int i = 2; i < s.length(); i++){
            if (s.charAt(i) != '0'){
                dp[i] += dp[i - 1];
            }else {
                dp[i] = dp[i - 2];
            }

            if (Integer.parseInt(s.substring(i - 1, i + 1)) > 10 && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26 && s.charAt(i) != '0'){
                dp[i] += dp[i - 2];
            }

            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0'){
                return 0;
            }
            if (s.charAt(i) == '0' && s.charAt(i - 1) > '2'){
                return 0;
            }


        }

        return dp[s.length() - 1];
    }
}
