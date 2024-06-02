package coding.bzc;

/**
 * @ClassNAME FileNameSuffixTest
 * @Description TODO
 * @Author yu
 */
public class FileNameSuffixTest {
    public static void main(String[] args) {
        String fileName = "group/1712409886744/二类卡账户银行流水导出时间-2024-04-06.xlsx";

        if (fileName.lastIndexOf(".") == -1){
            System.out.println("没有后缀");
        }else {
            System.out.println("有后缀");
        }
    }
}
