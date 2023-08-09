package coding.easy;

/**
 * @ClassNAME ReverseString
 * @Description 反转字符串
 * @Author yu
 * @Date 2023/8/7 15:34
 * @Version 1.0
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }
}
