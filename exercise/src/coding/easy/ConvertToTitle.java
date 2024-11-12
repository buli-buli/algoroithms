package coding.easy;

import java.util.Arrays;

/**
 * @author yzw
 * @Description Excel表列名称
 * @createTime 2024年09月23日
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        ConvertToTitle c = new ConvertToTitle();
        System.out.println(c.convertToTitle(701));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0){

            int a0 = (columnNumber - 1) % 26 + 1;

            sb.append((char)('A' + a0 - 1));
            columnNumber -= a0;
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
