package coding.bzc;

import java.util.*;

/**
 * @ClassNAME DateCompareTest
 * @Description Date对象测试类
 * @Author yu
 */
public class DateCompareTest {
    public static void main(String[] args) {
        DateCompareTest dt = new DateCompareTest();
//        dt.testCompareDate();
//        dt.testGetDateByCalendar();
    }

    public void testGetDateByCalendar(){
        String dateStr = "1,2,3,4,5";
        String[] days =  dateStr.split(",");
        Calendar calendar =Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        if(!Arrays.asList(days).contains(day+"")){
            return;
        }
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
