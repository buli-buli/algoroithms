package coding.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassNAME HavleArray
 * @Description 将数组和减半的最少操作次数
 * @Author yu
 * @Date 2023/7/25 12:31
 * @Version 1.0
 */
public class HalveArray {
    public static void main(String[] args) {
        HalveArray h = new HalveArray();
        int[] nums = new int[]{5,19,8,1};
        System.out.println(h.halveArray(nums));
    }
    public int halveArray(int[] nums){
        int res = 0;
        double sum = 0d, half;

        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++){
            queue.offer((double) nums[i]);
            sum+=nums[i];
        }

        half = sum / 2;

        double tmp = 0d;
        while (tmp < half){
            res++;
            double max = queue.poll();
            max/=2;
            tmp+=max;
            queue.add(max);
        }

        return res;
    }
}
