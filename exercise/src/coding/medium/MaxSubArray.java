package coding.medium;

/**
 * @author: yuzhiwei
 * @description: 最大子数组和（分治法）
 * @create: 2023/2/21 9:40
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(nums, 0, nums.length - 1));
    }

    static int maxSubArraySum(int[] nums, int low, int high){
        if (low == high){
            return nums[low];
        }

        int mid = low + (high - low)/ 2;

        int lefeSum = maxSubArraySum(nums, low, mid);
        int rightSum = maxSubArraySum(nums, mid + 1, high);
        int crossSum = maxCrossingSum(nums, low, mid, high);

        return Math.max(Math.max(lefeSum, rightSum), crossSum);
    }

    static int maxCrossingSum(int[] nums, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;

        //左半边
        for (int i = mid; i >= low; i--){
            sum += nums[i];
            if (sum > leftSum){
                leftSum = sum;
            }
        }

        //右半边
        sum = 0;
        for (int i = mid + 1; i <= high; i++){
            sum += nums[i];
            if (sum > rightSum){
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }
}
