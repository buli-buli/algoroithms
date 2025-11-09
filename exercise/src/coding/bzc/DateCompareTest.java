package coding.bzc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @ClassNAME DateCompareTest
 * @Description Date对象测试类
 * @Author yu
 */
public class DateCompareTest {
    public static void main(String[] args) throws ParseException {
        DateCompareTest dt = new DateCompareTest();
//        dt.testCompareDate();
//        dt.testCompareDate1();
//        dt.testGetDateByCalendar();
//        dt.testBigInteger();
//        dt.testLongIntegerCompare();
        dt.testLoaclDateBetween();
//        dt.testError();
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

    public void testCompareDate1() throws ParseException {
        Date checkTime = new Date();

        Date endTime = addDays(checkTime, 0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");

        String date1 = "2025-02-03 000000";
        String date2 = "2025-02-05 000000";

        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);

        System.out.println(d1.before(d2));
        System.out.println(d1.after(d2));
    }

    public void getNextQuarterFirstDay(Date curr){

    }

    public void testBigInteger(){
        Object b = "";

        BigInteger big = new BigInteger("1698675109117661185");


        System.out.println(big);
        System.out.println(big.longValue());



    }

    public void testJsonStr(){
        String jsonStr = "{}";


    }

    public void testLongIntegerCompare(){
        Long al = 1L;
        Integer ai = 2;

        Long bl = 2L;
        Integer bi = 1;

        System.out.println(al > ai);
        System.out.println(bl > bi);
    }

    public void testLoaclDateBetween(){
        LocalDate date1 = LocalDate.of(2023, 7, 21);
        LocalDate date2 = LocalDate.of(2028, 7, 20);


        LocalDate date3 = LocalDate.of(2025, 7, 1);
        LocalDate date4 = LocalDate.of(2030, 6, 30);


        LocalDate date5 = LocalDate.of(2020, 7, 7);
        LocalDate date6 = LocalDate.of(2025, 7, 6);

        LocalDate date7 = LocalDate.of(2025, 7, 1);
        LocalDate date8 = LocalDate.of(2025, 7, 6);

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        long daysBetweenTot = ChronoUnit.DAYS.between(date3, date4);


        long daysBetween3 = ChronoUnit.DAYS.between(date5, date6);
        long daysBetween4 = ChronoUnit.DAYS.between(date7, date8);
        System.out.println("相差天数1: " + daysBetween);
        System.out.println("相差天数2: " + daysBetweenTot);


        System.out.println("相差天数3: " + daysBetween3);
        System.out.println("相差天数4: " + daysBetween4);
    }

    public void testError(){
        BigDecimal money = new BigDecimal(1000);

        LocalDate head = LocalDate.of(2024, 1, 1);
        LocalDate tail = LocalDate.of(2035, 12, 31);


        LocalDate middle = LocalDate.of(2025, 9, 10);


        Long area1 = ChronoUnit.DAYS.between(head, middle);
        Long area2 = ChronoUnit.DAYS.between(middle, tail);

        Long tot = ChronoUnit.DAYS.between(head, tail);


        System.out.println(area1);
        System.out.println(area2);
        System.out.println(tot);

        BigDecimal money1 = money.multiply(BigDecimal.valueOf(area1)).divide(BigDecimal.valueOf(tot), 5, BigDecimal.ROUND_HALF_UP);
        BigDecimal money2 = money.multiply(BigDecimal.valueOf(area2)).divide(BigDecimal.valueOf(tot), 5, BigDecimal.ROUND_HALF_UP);

        System.out.println("area1金额: " + money1);
        System.out.println("area2金额: " + money2);
        System.out.println("总金额: " + money1.add(money2).toString());
    }
}
