package coding.easy;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/8 10:43
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' '){
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' '){
            start--;
        }

        return end - start;
    }
}
