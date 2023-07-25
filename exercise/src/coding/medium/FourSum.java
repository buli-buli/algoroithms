package coding.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNAME FourSum
 * @Description 四数之和
 * @Author yu
 * @Date 2023/7/25 15:11
 * @Version 1.0
 */
public class FourSum {
    public static void main(String[] args) {
        FourSum f = new FourSum();
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(f.fourSum(nums, -294967296));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length < 4){
            return ans;
        }

        long sum4 = (long) nums[0] + nums[1] + nums[2] + nums[3];
        long max3 = (long)nums[n - 1] + nums[n - 2] + nums[n -3];
        long sum3;
        long max2 = (long) nums[n - 1] + nums[n - 2];


        for (int i = 0; i < n - 3; ++i){
            if (sum4 > target){
                break;
            }
            if (i + 4 < n){
                sum4 = sum4 - nums[i] + nums[i + 4];
            }
            if (i > 0 && nums[i] == nums[i - 1] ){
                continue;
            }
            if (max3 + nums[i] < target){
                continue;
            }
            sum3 = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            for (int j = i + 1; j < n - 2; ++j){
                if (sum3 > target){
                    break;
                }
                if (j + 3 < n){
                    sum3 = sum3 - nums[j] + nums[j + 3];
                }
                if (j > i + 1 && nums[j] == nums[j - 1] ){
                    continue;
                }

                long val = (long) target - nums[i] - nums[j];
                if (max2 < val){
                    continue;
                }
                int l = j + 1;
                int r = n - 1;

                while (l < r){
                    int sum = nums[l] + nums[r];

                    if (sum > val){
                        --r;
                    }else if (sum < val){
                        ++l;
                    }else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        --r;
                        ++l;
                        while(l < r && nums[r] == nums[r + 1]) --r;
                        while(l < r && nums[l] == nums[l - 1]) ++l;
                    }
                }
            }
        }

        return ans;
    }
}
