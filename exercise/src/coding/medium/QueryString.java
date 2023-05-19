package coding.medium;

/**
 * @ClassNAME QueryString
 * @Description 子串能表示从 1 到 N 数字的二进制串
 * @Author yu
 * @Date 2023/5/11 14:16
 * @Version 1.0
 */
public class QueryString {
    public static void main(String[] args) {
        QueryString q = new QueryString();
        System.out.println(q.queryString("0110", 3));
    }
    public boolean queryString(String s, int n) {
        if (n == 1){
            return s.contains("1");
        }

        if (n > 1000){
            return false;
        }

        int flag = 1;

        while(flag <= n){
            if (!s.contains(Integer.toBinaryString(flag))){
                return false;
            }

            flag++;
        }

        return true;
    }
}
