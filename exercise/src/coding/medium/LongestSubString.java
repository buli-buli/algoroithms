package coding.medium;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2026年02月02日
 */
public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    private static int getLongestSubString(char[] a, char[] b) {
        int[][] f = new int[100][100];
        for (int i = 1; i < a.length; i++){
            for (int j = 1; j < b.length; j++){
                if (a[i] == b[j]){
                    f[i][j] = f[i - 1][j - 1] + 1;
                }else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[a.length - 1][b.length - 1];
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] f = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1] + 1;
                }else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[text1.length()][text2.length()];
    }
}
