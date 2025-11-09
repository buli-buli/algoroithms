package coding.medium;

import com.sun.deploy.util.StringUtils;

/**
 * @author yzw
 * @Description 最长回文子串
 * @createTime 2025年08月15日
 */
public class LongestHuiwenSubstring {
    public static void main(String[] args) {
        //System.out.println(countByViolence("bbbab"));
        Solution1 s = new Solution1();
        System.out.println(s.longestPalindromeSubseq("bbbab"));
    }

    static String countByViolence(String str){
        String res = "";

        for (int i = 0; i <= str.length(); i++){
            for (int j = 0; j <= str.length(); j++){
                if (j > i){
                    String subStr = str.substring(i,j);
                    if (isHuiwen(subStr) && subStr.length() > res.length()){
                        res = subStr;
                    }
                }
            }
        }

        return res;
    }

    private static Boolean isHuiwen(String s){
        Boolean res = true;
        if (null != s && !"".equals(s)){
            int l = 0, r = s.length() - 1;
            while (l <= r){
                if (s.charAt(l) != s.charAt(r)){
                    res = false;
                    break;
                }
                l++;
                r--;
            }
        }
        return res;
    }


}


class Solution1 {
    public int longestPalindromeSubseq(String s) {
        String res = "";

        for (int i = 0; i <= s.length(); i++){
            for (int j = 0; j <= s.length(); j++){
                if (j > i){
                    String subStr = s.substring(i,j);
                    if (isHuiwen(subStr) && subStr.length() > res.length()){
                        res = subStr;
                    }
                }
            }
        }

        return res.length();
    }

    private static Boolean isHuiwen(String s){
        Boolean res = true;
        if (null != s && !"".equals(s)){
            int l = 0, r = s.length() - 1;
            while (l <= r){
                if (s.charAt(l) != s.charAt(r)){
                    res = false;
                    break;
                }
                l++;
                r--;
            }
        }
        return res;
    }
}