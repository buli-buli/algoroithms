package coding.easy;

import java.util.Arrays;

/**
 * @ClassNAME MoveZeroes
 * @Description 移动零
 * @Author yu
 * @Date 2023/8/8 16:27
 * @Version 1.0
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();

        int[] nums = new int[]{0,0,1};
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int i = 0, head = 0;
        while(i < n){
            if (nums[i] != 0){
                nums[head] = nums[i];
                head++;
            }

            i++;
        }

        for (int j = head; j < n; j++){
            nums[j] = 0;
        }
    }
}
