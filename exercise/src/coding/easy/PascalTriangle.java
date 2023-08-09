package coding.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNAME PascalTriangle
 * @Description 杨辉三角
 * @Author yu
 * @Date 2023/8/7 16:34
 * @Version 1.0
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();

        System.out.println(p.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(Arrays.asList(1));
        if (numRows == 1){
            return ans;
        }

        ans.add(Arrays.asList(1,1));
        if (numRows == 2){
            return ans;
        }


        int i = 2;
        while(i < numRows){
            List<Integer> row = new ArrayList<>();
            //开头的数
            row.add(1);
            //由上一行数得出的数
            List<Integer> lastRow = ans.get(i - 1);
            for (int j = 0; j < lastRow.size() - 1; j++){
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            //结尾的数
            row.add(1);

            //把第i行加入结果集ans
            ans.add(row);
            i++;
        }

        return ans;
    }
}
