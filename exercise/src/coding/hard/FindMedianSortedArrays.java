package coding.hard;

import java.util.Arrays;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/6 16:53
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,4};
        int[] nums2 = new int[] {5,6,7,8};

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
        //两个数组长度
        int lengthSum = nums1.length + nums2.length;
        int a = lengthSum / 2 - 1;
        int aValue = 0;
        int b = lengthSum / 2;
        int bValue = 0;
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;

        while (flag3 <= b && (flag1 < nums1.length && flag2 < nums2.length)){
            if (nums1[flag1] < nums2[flag2]){
                if (flag3 == a){
                    aValue = nums1[flag1];
                }
                if (flag3 == b){
                    bValue = nums1[flag1];
                }
                flag1++;
                flag3++;
            }else if (nums1[flag1] > nums2[flag2]){
                if (flag3 == a){
                    aValue = nums2[flag2];
                }
                if (flag3 == b){
                    bValue = nums2[flag2];
                }
                flag3++;
                flag2++;
            }else {
                if (flag3 == a){
                    aValue = nums1[flag1];

                }
                if (flag3 == b){
                    bValue = nums1[flag1];
                }
                flag1++;
                flag3++;
            }
        }

        if (flag1 >= nums1.length){
            while(flag3 <= b && flag2 < nums2.length){
                if (flag3 == a){
                    aValue = nums2[flag2];
                }
                if (flag3 == b){
                    bValue = nums2[flag2];
                }
                flag3++;
                flag2++;
            }
        }

        if (flag2 >= nums2.length){
            while(flag3 <= b && flag1 < nums1.length){
                if (flag3 == a){
                    aValue = nums1[flag1];
                }
                if (flag3 == b){
                    bValue = nums1[flag1];
                }
                flag1++;
                flag3++;
            }
        }

        if (lengthSum % 2 != 0){
            System.out.println(bValue / 1d);
            return bValue / 1d;
        }else {
            System.out.println((aValue + bValue) / 2d);
            return (aValue + bValue) / 2d;
        }
    }
}
