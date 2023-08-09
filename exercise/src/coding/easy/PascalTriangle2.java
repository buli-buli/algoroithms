package coding.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNAME PascalTriangle2
 * @Description 杨辉三角Ⅱ
 * @Author yu
 * @Date 2023/8/7 16:54
 * @Version 1.0
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        PascalTriangle2 p2 = new PascalTriangle2();

        System.out.println(p2.getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> lastRow;
        List<Integer> ans = new ArrayList<>();

        lastRow = Arrays.asList(1);
        if (rowIndex == 1){
            return lastRow;
        }

        lastRow = Arrays.asList(1,1);
        if (rowIndex == 2){
            return lastRow;
        }


        int i = 2;
        while(i < rowIndex){
            List<Integer> row = new ArrayList<>();
            //开头的数
            row.add(1);
            //由上一行数得出的数
            for (int j = 0; j < lastRow.size() - 1; j++){
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            //结尾的数
            row.add(1);

            //将当前行保存为下一次循环的lastRow
            lastRow = row;
            i++;

            if (i == rowIndex){
                ans = row;
            }
        }

        return ans;
    }
}
