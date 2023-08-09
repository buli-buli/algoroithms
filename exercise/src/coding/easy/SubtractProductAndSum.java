package coding.easy;

/**
 * @ClassNAME SubtractProductAndSum
 * @Description 整数的各位积和之差
 * @Author yu
 * @Date 2023/8/9 14:07
 * @Version 1.0
 */
public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while(n >= 1){
            int mod = n % 10;

            product*=mod;
            sum+=mod;

            n /= 10;
        }

        return product - sum;
    }
}
