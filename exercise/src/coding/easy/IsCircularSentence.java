package coding.easy;

/**
 * @ClassNAME IsCircularSentence
 * @Description 回环句
 * @Author yu
 * @Date 2023/6/30 16:57
 * @Version 1.0
 */
public class IsCircularSentence {
    public static void main(String[] args) {
        IsCircularSentence i = new IsCircularSentence();
        String sentence = "leetcode exerciseb sound delightful";
        System.out.println(i.isCircularSentence(sentence));
    }
    public boolean isCircularSentence(String sentence) {
        int i = 0;
        char first = sentence.charAt(i);
        while(i < sentence.length()){
            char c = sentence.charAt(i);
            if (c == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)){
                return false;
            }
            i++;
        }
        char last = sentence.charAt(i - 1);
        if (first != last){
            return false;
        }

        return true;
    }
}
