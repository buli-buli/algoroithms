package coding.easy;

/**
 * @ClassNAME HammingWeight
 * @Description 位1的个数
 * @Author yu
 * @Date 2023/8/7 18:09
 * @Version 1.0
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }
}
