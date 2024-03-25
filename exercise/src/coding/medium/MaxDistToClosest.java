package coding.medium;

/**
 * @ClassNAME MaxDistToClosest
 * @Description 到最近的人的最大距离
 * @Author yu
 * @Date 2023/8/22 15:02
 * @Version 1.0
 */
public class MaxDistToClosest {
    public static void main(String[] args) {
        int[] seats = new int[]{1,0,0,0,1,0,1};

        MaxDistToClosest m = new MaxDistToClosest();
        System.out.println(m.maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        int l = 0, r, res = 0;

        while (seats[l] == 1){
            l++;
        }

        while (l < seats.length){
            r = l;
            while (r < seats.length && seats[r] == 0){
                r++;
            }

            int max;
            if (l == 0 || r == seats.length){
                max = r - l;
            }else {
                max = (r - l + 1) / 2;
            }

            res = Math.max(res, max);

            r++;
            l = r;
        }

        return res;
    }
}
