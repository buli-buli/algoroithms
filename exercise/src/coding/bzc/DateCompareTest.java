package coding.bzc;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassNAME DateCompareTest
 * @Description Date对象测试类
 * @Author yu
 */
public class DateCompareTest {
    public static void main(String[] args) {
        DateCompareTest dt = new DateCompareTest();
//        dt.testCompareDate();


    }



    public void testCompareDate(){
        Date checkTime = new Date();

        Date endTime = addDays(checkTime, -1);

        System.out.println(checkTime.compareTo(endTime));
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }
}
