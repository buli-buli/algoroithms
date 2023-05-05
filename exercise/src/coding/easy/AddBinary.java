package coding.easy;

/**
 * @ClassNAME AddBinary
 * @Description 二进制字符串求和
 * @Author yu
 * @Date 2023/4/28 17:53
 * @Version 1.0
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary a = new AddBinary();

        String s = a.addBinary("1010", "1011");

        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();

        int distance = 0;

        boolean mBigger = false;

        if (m.length >= n.length){
            mBigger = true;
            distance = m.length - n.length;
        }else {
            distance = n.length - m.length;
        }

        int bigger = mBigger ? m.length : n.length;
        char[] res = new char[bigger];

        int begin = bigger - 1;
        int isPush = 0;
        while(begin >= 0){
            int sum = 0;

            if (mBigger){
                sum += Integer.parseInt(String.valueOf(m[begin]));
                if (begin - distance >= 0){
                    sum += Integer.parseInt(String.valueOf(n[begin - distance]));
                }
                sum += isPush;
            }else {
                sum += Integer.parseInt(String.valueOf(n[begin]));
                if (begin - distance >= 0){
                    sum += Integer.parseInt(String.valueOf(m[begin - distance]));
                }
                sum += isPush;
            }

            if (sum > 1){
                isPush = sum / 2;
                sum = sum % 2;
            }else {
                isPush = 0;
            }

            res[begin] = (char)(sum + '0');
            begin--;

        }

        String resStr = new String(res);

        if (0 == isPush){
            return resStr;
        }else {
            return "1" + resStr;
        }
    }
}
