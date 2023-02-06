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

        findMedianSortedArrays1(nums1, nums2);
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

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        //合并两个数组
        int[] nums3 = new int[nums1.length + nums2.length];
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;

        while (flag1 < nums1.length || flag2 < nums2.length){
            if (nums1[flag1] < nums2[flag2]){
                nums3[flag3] = nums1[flag1];
                flag1++;
                flag3++;
            }else if (nums1[flag1] > nums2[flag2]){
                nums3[flag3] = nums2[flag2];
                flag3++;
                flag2++;
            }else {
                nums3[flag3] = nums1[flag1];
                flag3++;
                nums3[flag3] = nums2[flag2];
                flag1++;
                flag2++;
                flag3++;
            }
        }

        if (nums3.length % 2 != 0){
            System.out.println(nums3[nums3.length / 2] / 1d);
            return nums3[nums3.length / 2] / 1d;
        }else {
            System.out.println((nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2d);
            return (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2d;
        }
    }
}
