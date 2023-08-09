package coding.easy;

import java.util.Arrays;

/**
 * @ClassNAME SingleNumber
 * @Description 只出现一次的数字
 * @Author yu
 * @Date 2023/8/7 17:24
 * @Version 1.0
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,4};
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int i = 0,single = 0;
        while(i < nums.length){
            single ^= nums[i];

            i++;
        }

        return single;
    }
}
