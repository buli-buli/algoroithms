package coding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuzhiwei
 * @description: 1：两数之和
 * @create: 2023/2/6 16:43
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            indexMap.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            if (null != indexMap.get(nums[i]) && i != indexMap.get(nums[i])){
                return new int[]{i, indexMap.get(nums[i])};
            }
        }

        return new int[]{0,1};
    }
}
