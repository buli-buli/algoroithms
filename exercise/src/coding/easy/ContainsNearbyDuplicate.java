package coding.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassNAME ContainsNearbyDuplicate
 * @Description 存在重复元素 II
 * @Author yu
 * @Date 2023/8/7 18:22
 * @Version 1.0
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k){
                return true;
            }else {
                map.put(nums[i], i);
            }

        }

        return false;
    }
}
