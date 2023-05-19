package coding.medium;

/**
 * @ClassNAME IntToRoman
 * @Description 整数转罗马数字
 * @Author yu
 * @Date 2023/5/19 15:55
 * @Version 1.0
 */
public class IntToRoman {
    public static void main(String[] args) {
        IntToRoman i = new IntToRoman();

        System.out.println(i.intToRoman(9867));
    }

    public String intToRoman(int num) {

        int[] romans = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String res = "";

        int flag = 0;

        while(num >= 1){
            int romansNum = romans[flag];
            if (num / romansNum != 0){
                num -= romans[flag];
                res += getRomanString(romansNum);
            }else {
                flag++;
            }
        }

        return res;
    }

    public static String getRomanString(int num){
        switch (num){
            case 1 :
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }
}
