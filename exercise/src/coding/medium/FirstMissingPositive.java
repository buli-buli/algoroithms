package coding.medium;

import java.util.Arrays;

/**
 * @ClassNAME FirstMissingPositive
 * @Description 缺失的第一个正数
 * @Author yu
 * @Date 2023/6/27 15:42
 * @Version 1.0
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();

        int[] nums = new int[]{7,8,9,11,12};
        System.out.println(f.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            i++;
        }

        i = 0;
        while(i < nums.length){
            if (nums[i] != i + 1){
                return i + 1;
            }

            i++;
        }

        return nums.length + 1;
    }
}
