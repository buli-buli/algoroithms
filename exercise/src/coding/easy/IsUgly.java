package coding.easy;

/**
 * @author yzw
 * @Description 263、丑数
 * @createTime 2026年03月25日
 */
public class IsUgly {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(14));
    }
    static boolean isUgly(int n) {
        while(n % 2 == 0){
            n /= 2;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        while (n % 5 == 0){
            n /= 5;
        }

        return n == 1;
    }
}
