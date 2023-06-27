package coding.medium;

/**
 * @ClassNAME ConvertNString
 * @Description 6. N 字形变换
 * @Author yu
 * @Date 2023/6/26 12:10
 * @Version 1.0
 */
public class ConvertNString {
    public static void main(String[] args) {
        ConvertNString c = new ConvertNString();

        System.out.println(c.convert("A", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        //计算一个周期有多少个字符
        int round = 2 * numRows - 2;
        //计算矩阵的列数
        int col = ((s.length() / numRows) + 1) * numRows;

        char res[][] = new char[numRows][col];

        int mod, circle;
        int p, q;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //当前字符在周期中的哪个位置
            mod = i % round;
            //当前在第几个周期
            circle = i / round;

            //计算当前字符在矩阵中的行下标
            p = mod < numRows ? mod : numRows - mod % numRows - 2;
            //计算当前字符在矩阵中的列下标
            q = mod < numRows ? circle * (numRows - 1) : circle * (numRows - 1) + mod % (numRows - 1);

            res[p][q] = c;

        }

        StringBuffer b = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if(res[i][j] != '\0'){
                    b.append(res[i][j]);
                }
            }
        }

        return b.toString();
    }
}
