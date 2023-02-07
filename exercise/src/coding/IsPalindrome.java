package coding;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/6 17:58
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
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
}
