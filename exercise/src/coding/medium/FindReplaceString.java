package coding.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNAME FindReplaceString
 * @Description 字符串中的查找与替换
 * @Author yu
 * @Date 2023/8/15 18:30
 * @Version 1.0
 */
public class FindReplaceString {
    public static void main(String[] args) {
        String s = "vmokgggqzp";
        int[] indices = new int[]{1,3,5};
        String[] sources = new String[]{"mo","kg","ggq"};
        String[] targets = new String[]{"bfr","s","so"};

        FindReplaceString f = new FindReplaceString();
        System.out.println(f.findReplaceString(s, indices, sources, targets));
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int flag = 0, indexSum = 0;
        StringBuilder builder = new StringBuilder(s);

        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++){
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }

        Arrays.sort(indices);

        while (flag < indices.length){
            int index = indices[flag];
            String source = sourceMap.get(index);
            String target = targetMap.get(index);

            if (s.startsWith(source, index)){
                int begin = index + indexSum, end = index + source.length() + indexSum;
                System.out.print("begin :" + begin + " end: " + end + " indexSum: " + indexSum + " ");
                builder.replace(begin, end, target);
                System.out.println("res: " + builder.toString());
                indexSum = indexSum + target.length() - end + begin;
            }

            flag++;
        }

        return builder.toString();
    }
}
