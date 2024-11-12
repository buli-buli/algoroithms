package coding.medium;

/**
 * @author yzw
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @createTime 2024年11月12日
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int a = -1,b=-1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                a = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] == target){
                b = i;
                break;
            }
        }

        return new int[]{a,b};
    }
}
