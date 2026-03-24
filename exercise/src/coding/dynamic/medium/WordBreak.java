package coding.dynamic.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author yzw
 * @Description 139、单词拆分
 * @createTime 2026年03月24日
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("cars", Arrays.asList("car","ca","rs")));
    }

    static boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j <= i; j++){
                String sub = s.substring(j, i);
                dp[i] = dp[j] && wordDict.contains(sub);
                if (dp[i]){
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
