package coding.dynamic.medium;

import coding.MyUtil;

/**
 * @author yzw
 * @Description 221、最大正方形
 * @createTime 2026年03月24日
 */
public class MaximalSquareViolent {
    public static void main(String[] args) {
        //System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]")));
        //System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"0\",\"1\"],[\"1\",\"0\"]]")));
        System.out.println(maximalSquare(MyUtil.parseStringMatrix("[[\"1\",\"1\"],[\"1\",\"1\"]]")));

    }

    static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    max = Math.max(max, 1);
                    int maxPossibleLength = Math.min(m - i, n - j);

                    for (int k = 1; k <= maxPossibleLength; k++){
                        //System.out.println("i: " + i + ",j: " + j + ",k: " + k + ",maxPossibleLength: " + maxPossibleLength);
                        boolean flag = true;
                        for (int a = i; a < i + k; a++){
                            for (int b = j; b < j + k; b++){
                                if (matrix[a][b] == '0'){
                                    flag = false;
                                    break;
                                }
                            }
                            if (!flag){
                                break;
                            }
                        }
                        if (flag){
                            max = Math.max(max, k * k);
                        }
                    }
                }
            }
        }

        return max;
    }
}
