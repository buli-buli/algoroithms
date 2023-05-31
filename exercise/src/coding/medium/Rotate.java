package coding.medium;

import java.util.Arrays;

/**
 * @ClassNAME Rotate
 * @Description 48.旋转图像
 * @Author yu
 * @Date 2023/5/31 15:14
 * @Version 1.0
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        Rotate r = new Rotate();

        printArray(matrix);

        r.rotate(matrix);

        printArray(matrix);
    }

    public void rotate(int[][] matrix) {
        int m = matrix.length;

        //转置矩阵
        for (int i = 0; i < m; i++){
            for (int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //双指针逐行反转
        int left, right, temp;
        for (int i = 0; i < m; i++){
            left = 0;
            right = matrix[0].length - 1;

            while(left < right){
                temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] = temp;

                left++;
                right--;
            }
        }
    }

    public static void printArray(int[][] matrix){
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
