package coding.dynamic.medium;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 416、分割等和子集
 * @createTime 2026年02月25日
 */
public class CanPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }

    static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }

        int target = sum >> 1;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++){
            for (int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
