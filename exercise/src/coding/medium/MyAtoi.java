package coding.medium;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNAME MyAtoi
 * @Description 字符串转换整数 (atoi)
 * @Author yu
 * @Date 2023/5/10 11:45
 * @Version 1.0
 */
public class MyAtoi {
    public static void main(String[] args) {
        MyAtoi m = new MyAtoi();
        String s = "2147483646";


        System.out.println(m.myAtoi(s));
    }
    public int myAtoi(String s) {
        if ("".equals(s)){
            return 0;
        }

        String trimS = trimLeadingSpaces(s);

        boolean isNegative = false;
        char b[] = trimS.toCharArray();
        StringBuffer buffer = new StringBuffer();

        int flag = 0;

        while(flag < b.length){
            char c = b[flag];
            if (c <= 57 && c >= 48){
                //数字字符
                buffer.append(c);
            }else if (c == 45){
                if (flag == 0){
                    isNegative = true;
                }else {
                    break;
                }
            }else if (c == 43 && flag == 0){
                //无需做操作
            }else {
                break;
            }

            flag++;
        }
        if ("".equals(buffer.toString())){
            return 0;
        }

        String bufferStr = buffer.toString();

        if (bufferStr.length() > String.valueOf(Integer.MAX_VALUE).length()){
            bufferStr = bufferStr.substring(0, String.valueOf(Integer.MAX_VALUE).length());
        }

        long num = Long.parseLong(bufferStr);
        if (num > Integer.MAX_VALUE){
            if (isNegative){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        } else {
            if (isNegative){
                num = -num;
            }
            return (int) num;
        }
    }

    public static String trimLeadingSpaces(String str) {
        // 匹配前导空格的正则表达式
        String regex = "^\\s+";
        // 截取字符串的子串
        String result = str.replaceAll(regex, "");
        return result;
    }
}
