package coding.easy;

import java.util.Arrays;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/8 11:17
 **/
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{4,5,6};

        Merge m = new Merge();

        m.merge(nums1, 3, nums2 ,3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //合并两个数组

        int flag1 = m - 1;
        int flag2 = n - 1;
        int flag3 = m + n - 1;

        if (m == 0){
            for (int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }

        while (flag3 > 0 && (flag1 > 0 || flag2 > 0)){
            if (nums1[flag1] >= nums2[flag2]){
                nums1[flag3] = nums1[flag1];
                flag3--;
                if (flag1 > 0){
                    flag1--;
                }
            }else if (nums1[flag1] < nums2[flag2]){
                nums1[flag3] = nums2[flag2];
                flag3--;
                if (flag2 > 0){
                    flag2--;
                }
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
