package coding.easy;

import java.util.Arrays;

/**
 * @author: yuzhiwei
 * @description: 左右元素和差值
 * @create: 2023/2/27 10:09
 **/
public class LeftRigthDifference {
    public static void main(String[] args) {
        int[] nums = new int[]{10,6};

        System.out.println(Arrays.toString(leftRigthDifference(nums)));
    }

    public static int[] leftRigthDifference(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return new int[]{0};
        }

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] answer = new int[n];

        int l = 0;
        for (int i = 0; i < n; i++){
            leftSum[i] = l;
            l+=nums[i];
        }

        int r = 0;
        for (int i = n - 1; i >=0; i--){
            rightSum[i] = r;
            r+=nums[i];
        }

        for (int i = 0; i < n; i++){
            int a = leftSum[i] - rightSum[i];

            if (a > 0){
                answer[i] = a;
            }else {
                answer[i] = -a;
            }
        }

        return answer;
    }
}
