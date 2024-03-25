package coding.medium;

/**
 * @ClassNAME SearchSpinIndex
 * @Description 搜索旋转排序数组
 *          先找到k，然后切成两个数组二分查找
 * @Author yu
 */
public class SearchSpinIndex {
    public static void main(String[] args) {
        int[] nums = {3,5,1};

        SearchSpinIndex s = new SearchSpinIndex();
        System.out.println(getSpinIndex(nums));
        System.out.println(s.search(nums,1));
    }

    public int search(int[] nums, int target) {
        int res = -1;

        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        if (nums.length == 2){
            return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;
        }

        int k = getSpinIndex(nums);

        if (-1 == k){
            return getTargetIndex(nums,0, nums.length - 1, target);
        }

        //再分别对两个数组用二分法
        int index1 = getTargetIndex(nums,0,k,target);
        int index2 = getTargetIndex(nums,k + 1,nums.length - 1,target);

        if (-1 != index1){
            res = index1;
        }

        if (-1 != index2){
            res = index2;
        }

        return res;
    }

    public static int getSpinIndex(int[] nums){
        int l = 0, r = nums.length - 1;

        //先用二分法找到k
        while (l < r){
            int mid = (l + r) / 2;

            if (nums[mid] > nums[r]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }

        return l - 1;
    }

    public static int getTargetIndex(int[] nums,int l, int r, int target){
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
