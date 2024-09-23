package coding.easy;

/**
 * @author yzw
 * @Description 两数之和，暴力枚举
 * @createTime 2024年09月23日
 */
public class TwoNum {
    public int[] twoSum(int[] nums, int target) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i != j && nums[i] + nums[j] == target){
                    a = i;
                    b = j;
                }
            }
        }

        return new int[]{a,b};
    }
}
