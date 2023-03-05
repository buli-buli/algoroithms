package coding.easy;

/**
 * @ClassNAME PassThePillow
 * @Description 递枕头
 * @Author yu
 * @Date 2023/3/5 10:50
 * @Version 1.0
 */
public class PassThePillow {
    public static void main(String[] args) {
        System.out.println(passThePillow(8,9));
    }

    public static int passThePillow(int n, int time) {
        int round = n + n - 2;
        System.out.println(round);

        int mod = time % round;
        System.out.println(mod);

        if (mod < n){
            return mod + 1;
        }else {
            return n - (mod - n + 1);
        }
    }
}

