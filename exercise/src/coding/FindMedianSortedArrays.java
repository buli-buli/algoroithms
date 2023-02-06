package coding;

import java.util.Arrays;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/6 16:53
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3,5,7,9};
        int[] nums2 = new int[] {3,5,7,8,9};

        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并两个数组
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length + nums2.length; i++){
            if (i <= nums1.length - 1){
                nums3[i] = nums1[i];
            }else {
                nums3[i] = nums2[i - nums1.length];
            }
        }

        //排序
        Arrays.sort(nums3);

        if (nums3.length % 2 != 0){
            System.out.println(nums3[nums3.length / 2] / 1d);
            return nums3[nums3.length / 2] / 1d;
        }else {
            System.out.println((nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2d);
            return (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2d;
        }
    }
}
