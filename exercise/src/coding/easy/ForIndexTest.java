package coding.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME ForIndexTest
 * @Description TODO
 * @Author yu
 */
public class ForIndexTest {
    public static void main(String[] args) {
        List<OrdImportlistInfo> checkList2 = new ArrayList<>();

        for (int i = 0; i < 100000; i++){
            OrdImportlistInfo info = new OrdImportlistInfo(("key" + i),("value" + i));
            checkList2.add(info);
        }

        List<String> materialcodeList = new ArrayList<>();
        for (int i = 0; i < checkList2.size(); i++) {
            materialcodeList.add(checkList2.get(i).getValue1());
        }

        for (int i = 0; i< materialcodeList.size(); i++){
            String code = materialcodeList.get(i);

            if (!code.equals(checkList2.get(i).getValue1())){
                System.out.println("有问题！！！");
            }
        }
    }
}

class OrdImportlistInfo{
    private String value1;
    private String value2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public OrdImportlistInfo() {
    }

    public OrdImportlistInfo(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'';
    }
}
