package coding.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME MaximumEvenSplit
 * @Description 拆分成最多数目的正偶数之和
 * @Author yu
 * @Date 2023/7/6 16:46
 * @Version 1.0
 */
public class MaximumEvenSplit {
    public static void main(String[] args) {
        MaximumEvenSplit m = new MaximumEvenSplit();
        System.out.println(m.maximumEvenSplit(12));
    }
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0){
            return res;
        }

        long even = 2;
        while(finalSum >= even){
            res.add(even);
            finalSum -= even;
            even+=2;
        }

        res.set(res.size() - 1, res.get(res.size() -1) + finalSum);
        return res;
    }
}
