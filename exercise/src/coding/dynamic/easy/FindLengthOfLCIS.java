package coding.dynamic.easy;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 最长连续递增序列
 * @createTime 2026年02月05日
 */
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }

    static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;

        int max = dp[0];

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = 1;
            }

            if (dp[i] > max){
                max = dp[i];
            }
        }

        //System.out.println(Arrays.toString(dp));

        return max;
    }
}
