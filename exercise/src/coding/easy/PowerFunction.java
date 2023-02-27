package coding.easy;

/**
 * @author: yuzhiwei
 * @description: pow函数
 * @create: 2023/2/22 11:18
 **/
public class PowerFunction {
    public static void main(String[] args) {
        PowerFunction p = new PowerFunction();

        System.out.println(Math.pow(5,1000));
        System.out.println(p.myPow(5,1000));
    }

    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }

        double posResult = pow(x, n);

        return n > 0 ? posResult : 1 / posResult;
    }

    public double pow(double x, int n){
        if (n == 1 || n == -1){
            return x;
        }

        int mid = n / 2;
        double half = pow(x, mid);
        if (n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
    }
}
