package coding.medium;

import java.util.HashSet;

/**
 * @ClassNAME SmallestRepunitDivByK
 * @Description 可被k整除的最小整数
 * @Author yu
 * @Date 2023/5/10 10:35
 * @Version 1.0
 */
public class SmallestRepunitDivByK {
    public static void main(String[] args) {
        SmallestRepunitDivByK s = new SmallestRepunitDivByK();

        System.out.println(s.smallestRepunitDivByK(17));
    }

    public int smallestRepunitDivByK(int k) {
        int mod = 10 * 0 + 1;
        int len = 1;

        HashSet<Integer> modSet = new HashSet<>();

        if (k == 1) {
            return 1;
        }

        if (k % 2 == 0 || k % 5 == 0){
            return -1;
        }

        while(mod != 0){
            mod = ((mod * 10) + 1) % k;
            if (modSet.contains(mod)){
                break;
            }
            modSet.add(mod);
            len++;
        }

        return mod == 0 ? len : -1;
    }
}
