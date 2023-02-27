package coding.easy;

/**
 * @author: yuzhiwei
 * @description: 矩阵相乘法求斐波那契数
 * @create: 2023/2/22 11:16
 **/
public class Fibonacci {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int [][] c = f.fibonacci(200);
        System.out.print(c[0][0] + "，");
        System.out.println(c[0][1]);
        System.out.print(c[1][0] + "，");
        System.out.println(c[1][1]);
    }

    public int[][] fibonacci(int n) {
        int basicMatrix[][] = new int [][]{{1,1},{1,0}};

        if (n == 1){
            return basicMatrix;
        }

        int[][] half = fibonacci(n / 2);

        if (n % 2 == 0){
            return multiply(half, half);
        }else {
            return multiply(multiply(half, half), basicMatrix);
        }
    }

    public int[][] multiplycMatrix(int a[][], int b[][]){
        int c[][] = new int[2][2];
        c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];

        return c;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
}
