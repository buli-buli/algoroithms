package coding.easy;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/7 16:49
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();

        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(l.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        for (int i = 1; i < strs.length; i++){
            common = filterCommon(strs[i], common);
        }

        return common;
    }

    private String filterCommon(String str, String common) {
        int index = 0;
        boolean flag = true;
        while((index < str.length() && index < common.length()) && flag){
            if (!(str.charAt(index) == common.charAt(index))){
                flag = false;
            }
            if (flag){
                index++;
            }
        }
        common = common.substring(0, index);

        return common;
    }
}
