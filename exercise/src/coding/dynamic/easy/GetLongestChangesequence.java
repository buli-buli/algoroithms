package coding.dynamic.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yzw
 * @Description 最长相邻不相等子序列
 * @createTime 2026年02月03日
 */
public class GetLongestChangesequence {
    public static void main(String[] args) {
        GetLongestChangesequence g = new GetLongestChangesequence();
        g.getLongestSubsequence(new String[]{"a","b","c","d","e"}, new int[]{1,2,3,4,5});
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int flag = groups[0];
        res.add(words[0]);
        for (int i = 0; i < groups.length; i++){
            if (groups[i] != flag){
                res.add(words[i]);
                flag = flag == 1 ? 0 : 1;
            }
        }

        return res;
    }
}
