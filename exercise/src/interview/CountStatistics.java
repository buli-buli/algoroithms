package interview;

/**
 * @ClassNAME CountStatistics
 * @Description 统计返回各个数字都不同的数字x的个数
 * @Author yu
 * @Date 2023/10/12 16:49
 * @Version 1.0
 */
public class CountStatistics {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 10;
        }

        int cur = 10, res = 9;
        for (int i = 2; i <= n; i++){
            res *= (9 - (i - 2));
            cur += res;
        }

        return cur;
    }
}
