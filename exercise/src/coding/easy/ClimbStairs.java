package coding.easy;

/**
 * @ClassNAME ClimbStairs
 * @Description 爬楼梯
 * @Author yu
 * @Date 2023/8/7 15:56
 * @Version 1.0
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2){
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
