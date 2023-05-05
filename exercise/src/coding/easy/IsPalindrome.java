package coding.easy;

import java.util.Locale;

/**
 * @author: yuzhiwei
 * @description: 验证是否回文串
 * @create: 2023/2/6 17:58
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        String s = Integer.toString(x);

        int left;
        int right;
        int mid = s.length() / 2;

        if (s.length() % 2 == 0){
            left = mid - 1;
            right = mid;
        }else {
            left = right = mid;
        }

        while(left <= mid && right >= mid){
            System.out.println(s.charAt(left));
            System.out.println(s.charAt(right));
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        //去除非字母和数字字符
        String str = removeNonAlphanumeric(s);
        //字母全部改成小写
        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while(left <= right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static String removeNonAlphanumeric(String str) {
        String regex = "[^a-zA-Z0-9]";
        String result = str.replaceAll(regex, "");
        return result;
    }
}
