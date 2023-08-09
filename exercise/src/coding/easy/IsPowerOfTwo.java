package coding.easy;

/**
 * @ClassNAME IsPowerOfTwo
 * @Description 2 的幂
 * @Author yu
 * @Date 2023/8/8 15:45
 * @Version 1.0
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
