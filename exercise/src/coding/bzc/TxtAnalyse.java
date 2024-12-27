package coding.bzc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2024年12月27日
 */
public class TxtAnalyse {
    public static void main(String[] args) {
        String filePath = "D://FeishuDownload/报错入参.txt";

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 处理每一行文本
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sb.deleteCharAt(sb.indexOf("["));

        //System.out.println(sb.toString());

        int index = sb.indexOf("[");
        while (index != -1) {
            sb.deleteCharAt(index);
            index = sb.indexOf("[");
        }
        sb.deleteCharAt(sb.length() - 1);

        String[] objArray = sb.toString().split("],");

        Set<Integer> numSet = new HashSet<>();
        numSet.add(18);
        Integer count = 0;

        for (String obj : objArray){
            String[] group = obj.split(",");

            Integer num = group.length;
            if (!numSet.contains(num)){
                System.out.println(obj);
            }
        }
    }
}
