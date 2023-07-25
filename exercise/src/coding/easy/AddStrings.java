package coding.easy;

/**
 * @ClassNAME AddStrings
 * @Description 字符串相加
 * @Author yu
 * @Date 2023/7/24 9:47
 * @Version 1.0
 */
public class AddStrings {
    public static void main(String[] args) {
        AddStrings a = new AddStrings();

        String num1 = "584", num2 = "18";

        System.out.println(a.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        boolean isPush = false;
        int flag1 = num1.length() - 1,flag2 = num2.length() - 1;
        while (flag1 >= 0 && flag2 >= 0){
            int a = num1.charAt(flag1) - '0';
            int b = num2.charAt(flag2) - '0';

            int sum = a + b;

            if (isPush){
                res.append((sum + 1) % 10);
                if ((sum + 1) < 10){
                    isPush = false;
                }

            }else {
                res.append(sum % 10);
            }

            if (sum >= 10){
                isPush = true;
            }

            flag1--;
            flag2--;
        }

        if (flag1 >= 0){
            while (flag1 >= 0){
                int tmp = num1.charAt(flag1) - '0';
                if (isPush){
                    res.append((tmp + 1) % 10);
                    if ((tmp + 1) < 10){
                        isPush = false;
                    }
                }else {
                    res.append(tmp);
                }
                flag1--;
            }
        }

        if (flag2 >= 0){
            while (flag2 >= 0){
                int tmp = num2.charAt(flag2) - '0';
                if (isPush){
                    res.append((tmp + 1) % 10);
                    if ((tmp + 1) < 10){
                        isPush = false;
                    }

                }else {
                    res.append(tmp);
                }
                flag2--;
            }
        }

        if (isPush){
            res.append(1);
        }

        return res.reverse().toString();
    }
}
