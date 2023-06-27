package coding.medium;

import java.util.Arrays;

/**
 * @ClassNAME RemoveDuplicates
 * @Description 80.删除有序数组中的重复项Ⅱ
 * @Author yu
 * @Date 2023/5/31 15:54
 * @Version 1.0
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,4,5,5,5,6,6,6,6,7,7,8,9};

        RemoveDuplicates r = new RemoveDuplicates();

        int res = r.removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));

        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2,fast = 2;

        while(fast < nums.length) {
            if (nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }
}
