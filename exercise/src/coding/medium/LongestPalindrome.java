package coding.medium;

/**
 * @ClassNAME LongestPalindrome
 * @Description 最长回文子串
 * @Author yu
 * @Date 2023/7/6 17:12
 * @Version 1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        int max = -1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j <= s.length(); j++){
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > max){
                    max = sub.length();
                    res = sub;
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;

        while (l <= r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
