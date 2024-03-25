package coding.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME ForTest
 * @Description TODO
 * @Author yu
 */
public class ForTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();

        a.add("s1");

        for (int i = 0; i < a.size(); i++){
            for (int j = 0; j < a.size(); j++){
                String str1 = a.get(i);
                String str2 = a.get(j);
                if (i!=j && str1.equals(str2)){
                    System.out.println(str1);
                    return;
                }
            }
        }
    }
}
