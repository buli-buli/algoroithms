package coding.dynamic.medium;

/**
 * @author yzw
 * @Description 494、目标和
 * @createTime 2026年02月25日
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
        System.out.println(findTargetSumWays(new int[]{1000}, -1000));
    }

    static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if (Math.abs(target) > sum || (target + sum) % 2 != 0){
            return 0;
        }

        int finalTarget = (target + sum) >> 1;
        int[] dp = new int[finalTarget + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++){
            for (int j = finalTarget; j >= nums[i]; j--){
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[finalTarget];
    }
}
