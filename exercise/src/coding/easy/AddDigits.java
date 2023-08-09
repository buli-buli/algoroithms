package coding.easy;

/**
 * @ClassNAME AddDigits
 * @Description 各位相加
 * @Author yu
 * @Date 2023/8/8 15:52
 * @Version 1.0
 */
public class AddDigits {
    public static void main(String[] args) {
        AddDigits a = new AddDigits();

        System.out.println(a.addDigits(19));
    }

    public int addDigits(int num) {
        num = getAdd(num);
        while (num >= 10){
            num = getAdd(num);
        }

        return num;
    }

    public int getAdd(int num){
        int ans = 0;
        while (num > 0){
            ans += num % 10;
            num /= 10;
        }

        return ans;
    }
}
