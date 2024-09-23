package coding.easy;

/**
 * @ClassNAME ClimbStairs
 * @Description 爬楼梯
 * @Author yu
 * @Date 2023/8/7 15:56
 * @Version 1.0
 */
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(45));
    }

    public int climbStairs(int n) {
        int a=0,b=0,c = 1;

        for (int i = 1; i <= n; i++){
            a=b;
            b=c;
            c=a+b;
        }

        return c;
    }
}
