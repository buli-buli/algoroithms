package coding.bzc;

/**
 * @author yzw
 * @Description 今天吃什么好
 * @createTime 2024年09月23日
 */
public class EatWhat {
    public static void main(String[] args) {
        String[] menu = {"烧鹅","黄焖鸡","酸菜鱼"};

        Integer count = 0;
        while(count <= 100){
            count++;
            Integer mod = (count % 3) + 1;
            String msg = "";
            for(int i = 0; i < mod; i++){
                msg += ".";
            }
            System.out.println(msg);
        }


    }
}
