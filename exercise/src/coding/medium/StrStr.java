package coding.medium;

/**
 * @ClassNAME StrStr
 * @Description 找出字符串中第一个匹配项的下标
 * @Author yu
 * @Date 2023/6/27 15:15
 * @Version 1.0
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issi";

        StrStr s = new StrStr();
        System.out.println(s.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int i = 0;
        int l = 0;
        while(i < haystack.length() && l < needle.length()){
            if (needle.charAt(l) == haystack.charAt(i)){
                l++;

                if (l >= needle.length()){
                    return i - needle.length() + 1;
                }
            }else {
                i = i - l;
                l = 0;
            }

            i++;
        }

        return -1;
    }
}
