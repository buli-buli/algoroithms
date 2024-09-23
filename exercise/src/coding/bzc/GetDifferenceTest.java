package coding.bzc;

import java.util.HashSet;

/**
 * @ClassNAME GetDifferenceTest
 * @Description TODO
 * @Author yu
 */
public class GetDifferenceTest {
    public static void main(String[] args) {
        String s1 = "282778,282783,282784,282787,282789,282744,282807,282809,282810,282816,282845,282849,282856,282857,282870,282858,282939,282835,282892,282896,282964,282987,282972,283020,283021,282994,283076,283136,282922,283134,283161,283176,283177,283179,283180,283202,282973,283215,283205,283236,283153,283288,283324,283328,283376,283379,283380,283387,283491,283531,283547,283658,283660,283661,283659,283832,283761,283554,284027,283713,283722,284169,284127,284063,284189,284237,283667,284269,284326,284378,284427,284527,284310,284651,282871,283743,284102,284851,285014,285028,285029,285030,285013,284715,285031,285032,285038,285039,285043,285044,285045,285053,285055,285083,285094,285191,285192,285206,285208,285213,285231,285232,285195,285234,285238,285239,285240,285246,285248,285256,285257,285279,285280,285285,285293,285319,285321,285332,285335,285339,285149,285366,285396,285401,285405,285411,285414,285436,285434,284272,285589,285316,285233";
        String s2 = "282778,282783,282784,282787,282789,282744,282807,282809,282810,282816,282845,282849,282856,282857,282870,282858,282939,282835,282892,282896,282964,282987,282972,283020,283021,282994,283076,283136,282922,283134,283161,283176,283177,283179,283180,283202,282973,283215,283205,283236,283153,283288,283324,283328,283376,283379,283380,283387,283491,283531,283547,283658,283660,283661,283659,283832,283761,283554,284027,283713,283722,284169,284127,284063,284189,284237,283667,284269,284326,284378,284427,284527,284310,284651,282871,283743,284102,284851,285014,285028,285029,285030,285013,284715,285031,285032,285038,285039,285043,285044,285045,285053,285055,285083,285094,285191,285192,285206,285208,285213,285231,285232,285195,285234,285238,285239,285240,285246,285248,285256,285257,285279,285280,285285,285293,285319,285321,285332,285335,285339,285149,285366,285396,285401,285405,285411,285414,285436,285434,284272,285589,285316,285233";
        String[] arr1 = s1.split(",");
        String[] arr2 = s2.split(",");

        HashSet<String> set = new HashSet<>();
        HashSet<String> repeatSet = new HashSet<>();

        int count = 0;
        for (int i = 0; i < arr1.length; i++){
            if (set.contains(arr1[i])){
                repeatSet.add(arr1[i]);
            }else {
                set.add(arr1[i]);
            }
            if (!arr1[i].equals(arr2[i])){
                System.out.println(arr1[i]);
                System.out.println(arr2[i]);
                break;
            }
        }

        System.out.println(repeatSet.size());
        System.out.println(set.size());
    }
}