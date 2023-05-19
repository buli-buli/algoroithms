package coding.medium;

/**
 * @ClassNAME Reverse
 * @Description 整数反转
 * @Author yu
 * @Date 2023/5/11 17:10
 * @Version 1.0
 */
public class Reverse {
    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(r.reverse(1534236469));
    }

    public int reverse(int x) {
        String s = String.valueOf(x);

        boolean isNegative = false;

        char first = s.charAt(0);
        if (first == '-'){
            s = s.substring(1);
            isNegative = true;
        }
        if (first == '+'){
            s = s.substring(1);
        }

        StringBuilder builder = new StringBuilder(s);

        s = builder.reverse().toString();

        long longX = Long.parseLong(s);
        if (longX > Integer.MAX_VALUE){
            return 0;
        }

        return isNegative ? -Integer.parseInt(s) : Integer.parseInt(s);
    }
}
