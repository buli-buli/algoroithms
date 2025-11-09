package coding.easy;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2025年08月15日
 */
public class EasyPratice {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.isPowerOfFour(123));
    }
}


class Solution2 {
    public boolean isPowerOfFour(int n) {
        boolean res = false;

        for (int i = n / 2; i > 0; i--){
            if (i*i*i*i == n){
                return true;
            }
        }

        return res;
    }
}