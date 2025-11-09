package coding.easy;

/**
 * @author yzw
 * @Description 检查平衡字符串
 * @createTime 2025年03月14日
 */
public class IsBalanced {
    public static void main(String[] args) {
        IsBalanced i = new IsBalanced();
        System.out.println(i.isBalanced("354120454153245195747287259999564398065759880807557"));
    }

    public boolean isBalanced(String num) {
        boolean res = false;

        Integer sum = 0;
        Integer flag = 1;

        for (int i = 0; i < num.length(); i++){
            Integer currNum = num.charAt(i) - '0';
            sum += currNum * flag;
            flag = -flag;
        }

        if (sum == 0){
            res = true;
        }

        return res;

    }

}
