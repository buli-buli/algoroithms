package coding.dynamic.medium;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2026年02月04日
 */
public class Rob {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));;
    }

    static int rob(int[] nums){
        int[] dp = new int[nums.length + 1];

        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
