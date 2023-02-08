package coding.easy;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/8 10:15
 **/
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();

        int[] nums = new int[]{1,3,5,6};

        System.out.println(s.searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int low, int high, int[] nums, int target) {
        int mid = 0;
        while (low <= high){
            mid = (low + high) / 2;

            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }
}
