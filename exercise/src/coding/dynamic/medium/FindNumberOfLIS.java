package coding.dynamic.medium;

import coding.MyUtil;

import java.util.Arrays;

/**
 * @author yzw
 * @Description 最长递增子序列得个数
 * @createTime 2026年02月05日
 */
public class FindNumberOfLIS {
    int[] giao1 = new int[]{1,3,5,4,7};
    int[] giao2 = new int[]{2,2,2,2,2};
    int[] giao3 = new int[]{1,2,4,3,5,4,7,2};
    int[] giao4 = new int[]{1};
    int[] giao5 = new int[]{2,1};
    int[] giao6 = new int[]{1,1};
    int[] giao7 = new int[]{2,2};
    int[] giao8 = new int[]{1,3,2};
    int[] giao9 = new int[]{3,2,1};
    int[] giao10 = new int[]{4,6,7,7};
    int[] giao11 = new int[]{4,3,2,1};
    int[] giao12 = new int[]{1,2,3,8,8};
    int[] giao13 = new int[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

    public static void main(String[] args) {
//        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
//        System.out.println(findNumberOfLIS(new int[]{1, 5, 6, 4, 7}));
//        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
//        System.out.println(findNumberOfLIS(new int[]{3,1,2}));
//
//        System.out.println(findNumberOfLIS(new int[]{1,2}));
        System.out.println(findNumberOfLIS(new int[]{2,1}));
    }

    static int findNumberOfLIS(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int[] count = new int[nums.length];

        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            count[i] = 1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j <= i; j++){
                if (nums[i] > nums[j]){
                    if ((dp[j] + 1) > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];

                    }else if ((dp[j] + 1) == dp[i]){

                        count[i] += count[j];
                    }
                }
            }

            if (dp[i] > max){
                max = dp[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++){
            if (dp[i] == max){
                sum+= count[i];
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));

        return sum;
    }
}