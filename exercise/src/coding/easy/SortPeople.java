package coding.easy;

import java.util.Arrays;
import java.util.Comparator;

class SortPeople {
    public static void main(String[] args) {
        SortPeople s = new SortPeople();

        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights = new int[]{180,165,170};

        s.sortPeople(names, heights);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int[] newHeightInt = Arrays.copyOf(heights, heights.length);
        Integer[] newHeight = Arrays.stream(newHeightInt).boxed().toArray(Integer[]::new);
        String[] newName = new String[names.length];
        //newHeight数组逆序排序
        Arrays.sort(newHeight, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < newHeight.length; i++){
            Integer currMax = newHeight[i];
            for (int j = 0; j < names.length; j++){
                if(currMax == heights[j]){
                    newName[i] = names[j];
                    heights[j] = -1;
                    break;
                }
            }
        }

        return newName;
    }
}