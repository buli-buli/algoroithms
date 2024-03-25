package coding.easy;

/**
 * @ClassNAME MinNumber
 * @Description 从两个数字数组里生成最小数字
 * @Author yu
 * @Date 2023/9/5 18:07
 * @Version 1.0
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,3}, nums2 = new int[]{5,7};
        MinNumber m = new MinNumber();
        System.out.println(m.minNumber(nums1, nums2));
    }
    public int minNumber(int[] nums1, int[] nums2) {
        int count1 = 0, count2 = 0;
        boolean[] seat1 = new boolean[10];
        boolean[] seat2 = new boolean[10];

        int flag = 0;
        while (count1 < 10 && flag < nums1.length){
            if (!seat1[nums1[flag]]){
                seat1[nums1[flag]] = true;
                count1++;
            }
            flag++;
        }

        flag = 0;
        while (count2 < 10 &&flag < nums2.length){
            if (!seat2[nums2[flag]]){
                seat2[nums2[flag]] = true;
                count2++;
            }
            flag++;
        }

        for (int i = 1; i < 10; i++){
            if (seat1[i] && seat2[i]){
                return i;
            }
        }

        flag = 1;
        boolean found = false;
        int min1 = 0;
        while (!found && flag < 10){
            if (seat1[flag]){
                min1 = flag;
                found = true;
            }
            flag++;
        }

        flag = 1;found = false;
        int min2 = 0;
        while (!found && flag < 10){
            if (seat2[flag]){
                min2 = flag;
                found = true;
            }
            flag++;
        }

        return min1 < min2 ? (min1 * 10 + min2) : (min2 * 10 + min1);
    }
}
