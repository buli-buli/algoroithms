package coding.dynamic.medium;

import coding.MyUtil;

/**
 * @author yzw
 * @Description 221、最大正方形
 * @createTime 2026年03月24日
 */
public class MaximalSquare {
    public static void main(String[] args) {
        //System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]")));
        //System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"0\",\"1\"],[\"1\",\"0\"]]")));
        //System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"1\",\"1\"],[\"1\",\"1\"]]")));
        System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"0\",\"0\",\"1\",\"1\",\"1\"]]")));
    }

    static int maximalSquare(char[][] matrix) {
        //MyUtil.printCharArray(matrix);

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == '1'){
                max = 1;
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < n; j++){
            if (matrix[0][j] == '1'){
                max = 1;
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        //MyUtil.printArray(dp);

        return max * max;
    }
}
