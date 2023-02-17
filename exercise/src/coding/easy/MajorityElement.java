package coding.easy;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/17 11:20
 **/
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();

        int[] nums = new int[]{2,2,7,6,5,3,3,3,3,3,33,3,3,3,3,8,1,1,1,2,2};

        System.out.println(m.getMode(nums, 0, nums.length - 1));
    }

    public int majorityElement(int[] nums) {
        return getMode(nums, 0, nums.length - 1);
    }

    private int count(int[] nums, int num){
        int count = 0;

        for (int i = 0; i < nums.length; i++){
            if (num == nums[i]){
                count++;
            }
        }

        return count;
    }

    private int getMode(int[] nums, int low, int high){
        if (low == high){
            return nums[low];
        }

        int mid = (high - low) / 2 + low;
        int leftMode = getMode(nums, low, mid);
        int rightMode = getMode(nums, mid + 1, high);

        if (leftMode == rightMode){
            return leftMode;
        }

        int leftModeCount = count(nums, leftMode);
        int rightModeCount = count(nums, rightMode);

        return leftModeCount > rightModeCount ? leftMode : rightMode;
    }
}
