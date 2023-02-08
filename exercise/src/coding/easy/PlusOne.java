package coding.easy;

import java.util.Arrays;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/8 10:55
 **/
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3,4,5,6};

        PlusOne p = new PlusOne();
        System.out.println(Arrays.toString(p.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--){
            digits[i]++;
            digits[i] %= 10;

            if (0 != digits[i]){
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
