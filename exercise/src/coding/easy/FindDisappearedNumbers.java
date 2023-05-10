package coding.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNAME FindDisappearedNumbers
 * @Description 找到所有数组中消失的数字
 * @Author yu
 * @Date 2023/5/6 11:34
 * @Version 1.0
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        FindDisappearedNumbers f = new FindDisappearedNumbers();

        int[] nums = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(f.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int num : nums){
            int x = num % n;
            nums[x] += n;
        }

        for (int i = 0; i < n ;i++){
            if (nums[i] < n){
                res.add(i);
            }
        }

        return res;
    }
}
