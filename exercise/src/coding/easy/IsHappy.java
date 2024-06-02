package coding.easy;

/**
 * @ClassNAME IsHappy
 * @Description 快乐数
 * @Author yu
 */
public class IsHappy {
    public static void main(String[] args) {
        IsHappy i = new IsHappy();

        System.out.println(i.isHappy(1912312));
    }

    public boolean isHappy(int n) {
        int count = 0;
        int tmp = n;
        int sum;

        while(count < 100){
            sum = 0;

            while(tmp / 10 > 0 || tmp % 10 > 0){
                int p = tmp % 10;
                tmp /= 10;
                sum += p * p;
            }

            tmp = sum;
            if (tmp == n){
                return false;
            }

            System.out.println(sum);
            if (sum == 1){
                return true;
            }

            count++;

        }

        return false;
    }
}
