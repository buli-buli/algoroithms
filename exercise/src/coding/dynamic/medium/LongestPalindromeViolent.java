package coding.dynamic.medium;

/**
 * @author yzw
 * @Description 5、最长回文子串 暴力解法
 * @createTime 2026年02月26日
 */
public class LongestPalindromeViolent {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    static String longestPalindrome(String s) {
        String res = "";
        int max = -1;
        for (int i = 0; i <= s.length(); i++){
            for (int j = s.length(); j <= s.length(); j++){
                String sub = s.substring(i, j);
                if (isPalindrome(sub)){
                    if (sub.length() > max){
                        max = sub.length();
                        res = sub;
                    }
                }
            }
        }
        return res;
    }

    static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
