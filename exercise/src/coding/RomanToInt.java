package coding;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/7 16:05
 **/
public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt r = new RomanToInt();
        System.out.println(r.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int index = 0;
        int sum = 0;

        while(index < s.length()){
            char c = s.charAt(index);
            char c1 = '0';
            if (index < s.length() - 1){
                c1 = s.charAt(index + 1);
            }

            if((c == 'I' && (c1 == 'V' || c1 == 'X'))
                    || (c == 'X' && (c1 == 'L' || c1 == 'C'))
                    || (c == 'C' && (c1 == 'D' || c1 == 'M'))){
                sum+=getSpecialValue(c1);
                index += 2;
            }else{
                sum += getValue(c);
                index++;
            }
        }

        return sum;
    }

    public static int getValue(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return  50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static int getSpecialValue(char c){
        switch (c){
            case 'V':
                return 4;
            case 'X':
                return 9;
            case 'L':
                return 40;
            case 'C':
                return 90;
            case 'D':
                return 400;
            case 'M':
                return 900;
            default:
                return 0;
        }
    }
}
