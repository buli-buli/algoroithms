package coding.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNAME ThreeSum
 * @Description 三数之和
 * @Author yu
 * @Date 2023/6/27 9:20
 * @Version 1.0
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSum t = new ThreeSum();
        System.out.println(t.threeSum(nums).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //res保存所有结果
        List<List<Integer>> res = new ArrayList<>();
        //ans暂存单个结果
        List<Integer> ans;
        for (int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0 && l != i && r != i){
                    //暂存单个结果
                    ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);

                    //保存单个结果到结果集
                    res.add(ans);

                    //排除重复元素
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;
                }else if (sum > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }

        return res;
    }
}
