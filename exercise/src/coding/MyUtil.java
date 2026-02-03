package coding;

import java.util.Arrays;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2026年02月03日
 */
public class MyUtil {
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
