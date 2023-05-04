package coding.easy;

/**
 * @ClassNAME MySqrt
 * @Description TODO
 * @Author yu
 * @Date 2023/4/27 18:32
 * @Version 1.0
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt m = new MySqrt();

        System.out.println(m.mySqrtBinary(2147483647));

    }

    public int mySqrt(int x) {
        int mid = x / 2 + 1;
        for (int i = 1; i <= mid; i++){
            double m = (double) i * (double) i;
            if (m > x){
                return i - 1;
            }

            if (m == x){
                return i;
            }

            if (m < x && i == mid){
                return i;
            }
        }

        return 0;
    }

    public int mySqrtBinary(int x) {
        long left = 0;
        long right = x;

        while (left <= right){
            long mid = (left + right) / 2;

            long m = mid * mid;

            if (m == x){
                return (int) mid;
            }else if (m > x){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return (int)right;
    }
}
