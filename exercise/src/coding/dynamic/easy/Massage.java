package coding.dynamic.easy;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 按摩师
 * @createTime 2026年02月03日
 */
public class Massage {
    public static void main(String[] args) {
        System.out.println(massage(new int[]{2,1,4,5,3,1,1,3}));;
        System.out.println(massage(new int[]{}));;
    }
    static int massage(int[] nums) {
        int [] dp = new int[nums.length + 1];

        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int max = dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            int tmp = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            dp[i] = tmp;
            if (tmp > max){
                max = tmp;
            }
        }

        return max;
    }
}
