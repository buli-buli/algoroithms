package coding.easy;

import java.util.Arrays;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/16 9:53
 **/
public class NumberOfPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,1,3,2,2};

        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }

    public static int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);

        int[] pairs = new int[2];

        int count = 0;
        int flag = 0;

        while (flag < nums.length - 1){
            if (nums[flag] == nums[flag +1]){
                count++;
                flag+=2;
            }else {
                flag++;
            }
        }

        pairs[0] = count;
        pairs[1] = nums.length - count * 2;
        return pairs;
    }
}
