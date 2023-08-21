package coding.medium;

/**
 * @ClassNAME CanChange
 * @Description 移动片段得到字符串
 * @Author yu
 * @Date 2023/8/21 13:37
 * @Version 1.0
 */
public class CanChange {
    public static void main(String[] args) {
        CanChange c = new CanChange();
        String start = "___L___";
        String target = "_L_____";
        System.out.println(c.canChange(start, target));
    }
    public boolean canChange(String start, String target) {
        if(start.equals(target)){
            return true;
        }

        char[] s = start.toCharArray();
        char[] t = target.toCharArray();

        int i = 0, j = 0, n = start.length();

        while (i < n && j < n ){
            while (i < n && '_' == s[i]){
                i++;
            }
            while (j < n && '_' == t[j]){
                j++;
            }

            if (i < n && j < n){
                if (s[i] != t[j]){
                    return false;
                }

                if ((s[i] == 'L' && i < j) || s[i] == 'R' && i > j){
                    return false;
                }

                i++;
                j++;
            }
        }

        while (i < n){
            if (s[i] != '_'){
                return false;
            }
            i++;
        }
        while (j < n){
            if (t[j] != '_'){
                return false;
            }
            j++;
        }

        return true;
    }
}
