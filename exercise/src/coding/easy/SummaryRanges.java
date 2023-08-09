package coding.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME SummaryRanges
 * @Description 汇总区间
 * @Author yu
 * @Date 2023/8/8 15:13
 * @Version 1.0
 */
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        int[] nums = new int[]{0,1,2,4,5,7};

        System.out.println(s.summaryRanges(nums));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0, i = 0, n = nums.length;

        while(i < n){
            i++;
            while (i < n && nums[i] - nums[i - 1] == 1){
                r++;
                i++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(nums[l]);
            if (r > l){
                builder.append("->");
                builder.append(nums[r]);
            }
            ans.add(builder.toString());

            l = r = i;
        }

        return ans;
    }
}
