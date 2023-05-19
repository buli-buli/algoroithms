package coding.medium;

import java.util.Arrays;

/**
 * @ClassNAME SortColors
 * @Description 颜色分类
 * @Author yu
 * @Date 2023/5/19 17:29
 * @Version 1.0
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};

        SortColors s = new SortColors();
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                oneCount++;
            }
            if (nums[i] == 2){
                twoCount++;
            }
            if (nums[i] == 0){
                zeroCount++;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (zeroCount > 0){
                nums[i] = 0;
                zeroCount--;
            } else if (oneCount > 0){
                nums[i] = 1;
                oneCount--;
            }else if (twoCount > 0){
                nums[i] = 2;
                twoCount--;
            }
        }
    }
}
