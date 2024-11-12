package coding.easy;

/**
 * @author yzw
 * @Description 统计满足 K 约束的子字符串数量 I
 * @createTime 2024年11月12日
 */
public class CountKConstraintSubstrings {
    public int countKConstraintSubstrings(String s, int k) {
        int i = 0;
        int sum = 0;

        while (i < s.length()){
            int zeroCount = 0;
            int oneCount = 0;

            for (int j = i; j < s.length(); j++){
                if (s.charAt(j) == '0'){
                    zeroCount++;
                }
                if (s.charAt(j) == '1'){
                    oneCount++;
                }

                if (zeroCount <= k || oneCount <= k){
                    sum++;
                }
            }
            i++;
        }

        return sum;
    }
}
