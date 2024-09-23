package coding.easy;

/**
 * @author yzw
 * @Description Excel 表列序号
 * @createTime 2024年09月23日
 */
public class TitleToNumber {
    public static void main(String[] args) {
        TitleToNumber t = new TitleToNumber();
        System.out.println(t.titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {
        int res = 0;
        int m = 1;

        for (int i = columnTitle.length() - 1; i >= 0; i--){
            res += (columnTitle.charAt(i) - 'A' + 1) * m;
            m *= 26;
        }

        return res;
    }
}
