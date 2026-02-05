package coding.dynamic.medium;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 最长递增子序列
 * @createTime 2026年02月04日
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{1,2,3}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    static int lengthOfLIS(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        int max = Integer.MIN_VALUE;

        //System.out.println(Arrays.toString(nums));

        for (int i = 1; i < nums.length; i++){
            for (int j = 1; j <= i; j++){
                if (nums[i] > nums[j - 1]){
                    dp[i] =  Math.max((dp[j - 1] + 1), dp[i]);
                }
            }

            if (dp[i] > max){
                max = dp[i];
            }
        }
        //System.out.println();

        //System.out.println(Arrays.toString(dp));

        //System.out.println();

        return max;
    }
}
