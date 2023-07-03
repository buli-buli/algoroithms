package coding.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassNAME ThreeSumClosest
 * @Description 最接近的三数之和
 * @Author yu
 * @Date 2023/6/27 17:26
 * @Version 1.0
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest tc = new ThreeSumClosest();

        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(tc.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = target;
        int sum,differ,min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;

            while(l < r){
                sum = nums[r] + nums[l] + nums[i];
                differ = Math.abs(target - sum);
                if (differ < min && l != i && r != i){
                    min = differ;
                    res = sum;
                }

                if (sum == target){
                    return sum;
                }else if (sum < target){
                    l++;
                }else {
                    r--;
                }
            }
        }

        return res;
    }
}
