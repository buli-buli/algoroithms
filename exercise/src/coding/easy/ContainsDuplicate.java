package coding.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNAME ContainsDuplicate
 * @Description 存在重复元素
 * @Author yu
 * @Date 2023/8/7 18:16
 * @Version 1.0
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int count = map.containsKey(nums[i]) ? 1 : map.get(nums[i]) + 1;
            if (count > 1){
                return true;
            }

            map.put(nums[i], count);
        }

        return false;
    }
}
