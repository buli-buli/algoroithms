package coding.medium;

/**
 * @ClassNAME MaxArea
 * @Description 盛最多水的容器
 * @Author yu
 * @Date 2023/5/19 14:34
 * @Version 1.0
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea m = new MaxArea();

        int[] height = new int[]{1,1};

        System.out.println(m.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = -1;

        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);

            if (area > max){
                max = area;
            }

            if (height[left] >= height[right]){
                right--;
            }else {
                left++;
            }
        }

        return max;
    }
}
