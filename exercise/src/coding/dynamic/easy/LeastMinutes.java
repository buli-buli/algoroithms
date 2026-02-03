package coding.dynamic.easy;

/**
 * @author yzw
 * @Description 下载插件
 * @createTime 2026年02月02日
 */
public class LeastMinutes {
    public static void main(String[] args) {
        System.out.println(leastMinutes(9));
        System.out.println(leastMinutes(8));
        System.out.println(leastMinutes(7));
        System.out.println(leastMinutes(6));
        System.out.println(leastMinutes(5));
    }

    private static int leastMinutes(int n) {
        if (n == 2){
            return 2;
        }
        if (n == 1){
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int k = 1; k < n / 2; k++){
            int speed = 1 << k;

            int mod = n %speed;
            int tmp = k + (n / speed);
            if (mod > 0) {
                tmp ++;
            }

            min = Math.min(min, tmp);
        }

        return min;
    }
}
