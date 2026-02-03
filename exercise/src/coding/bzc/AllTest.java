package coding.bzc;

import javax.jnlp.IntegrationService;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @ClassNAME AllTest
 * @Description 各种测试
 * @Author yu
 */
public class AllTest {
    private static Random ran = new Random();

    public static void main(String[] args) throws ParseException, InterruptedException {
//        testStream();
//        testStringLength();
//        testLongToInt();
//        testFilter();
//        testTrim();
//        testSplit(true, "awdsad, aasd,");
//        testSplit1(true, ", aasd,");
//        testSplit2(true, "wadsd, aasd,,sfsd,");
//        testSplit3(false, "wadsd");
//        testPositionSum();
//        testBatchStringBuilder(1L);
//        testGetStandardfee(20, new BigDecimal("100"));
//        testChar();
//        System.out.println(testIntervalDays("2022-06-07","2022-06-08","yyyy-MM-dd"));
//        testHashMapInitSize();
//        testMinusDate();
//        testInStringLength();
//        testIntegerCompare();
//        testIntegerCompare1();
//        testCaught();
//        testDivide();
//        testBreak();
//        testEmptyBuilder();
//        testReplace();
//        testBuilder();
//        bigDecimalTest();
//        testMatchMonth();
//        testFun();
//        testHashMapSpace();
//        testGetTime();
//        testTimeCompare();
//        testQuickSort();
//        testChangeShort();
        testEmptyArrayStream();
    }

    private static void testTimeCompare() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date mergechecktime = sdf.parse("2023-09-14 17:14:16");

        Date jobExecuteTime = sdf.parse("2024-09-13 00:00:00");

        Calendar jobExecuteCalender = Calendar.getInstance();
        jobExecuteCalender.setTime(jobExecuteTime);
        jobExecuteCalender.set(Calendar.HOUR_OF_DAY, 0);
        jobExecuteCalender.set(Calendar.MINUTE, 0);
        jobExecuteCalender.set(Calendar.SECOND, 0);
        jobExecuteCalender.set(Calendar.MILLISECOND, 0);
        long jobExecuteMillis = jobExecuteCalender.getTimeInMillis();

        Calendar mergeTime = Calendar.getInstance();
        mergeTime.setTime(mergechecktime);
        mergeTime.set(Calendar.HOUR_OF_DAY, 0);
        mergeTime.set(Calendar.MINUTE, 0);
        mergeTime.set(Calendar.SECOND, 0);
        mergeTime.set(Calendar.MILLISECOND, 0);
        long mergeTimeMillis = mergeTime.getTimeInMillis();

        //2、根据并网时间，判断是否是间隔周期值
        if (mergechecktime != null) {
            long days = TimeUnit.MILLISECONDS.toDays(jobExecuteMillis - mergeTimeMillis);
            long value = Long.parseLong("365");
            //相差天数能整除间隔周期
            if (days >= value && days % value == 0) {
                System.out.println("giao");
            }
        }
    }

    private static void testGetTime() throws InterruptedException {


        System.out.println(new Date().getTime());
        System.out.println(String.valueOf(new Date().getTime()));
    }

    private static void testHashMapSpace() throws InterruptedException {
        Map<String, String> map = new HashMap<>();

        map.put("545 W", "giao");

        System.out.println(map.containsKey("545 W"));
    }

    private static void testFun() throws InterruptedException {
        Integer count = 0;
        int length = 200;

        int mark = -1;

        int flag = length;
        while(count <= 100000){
            flag += mark;

            for (int i = 0; i < flag; i++){
                System.out.printf("-");
            }
            System.out.println();

            if (flag > length){
                mark = -1;
            }
            if (flag <= 0){
                mark = 1;
            }

            count++;
        }
    }

    private static void testMatchMonth(){
        String date1 = "aaaa";
        String date2 = "bbbbb";
        String date3 = "9999-000";
        String date4 = "2022-05";

        //yyyy-MM
        String regexp="\\d{4}-(([0]+[1-9])|([1]+[0-2]))";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regexp);

        System.out.println(pattern.matcher(date1).matches());
        System.out.println(pattern.matcher(date2).matches());
        System.out.println(pattern.matcher(date3).matches());
        System.out.println(pattern.matcher(date4).matches());
    }

    private static void bigDecimalTest() {
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("100");

        System.out.println(a.subtract(b).toString());
    }

    private static void testEmptyBuilder() {
        StringBuilder buiulder = new StringBuilder();
        System.out.println(buiulder.toString());
    }

    static void testStream(){
        List<BillInfo> infos = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            BillInfo info = new BillInfo();
            info.setId(i + 1);

            if (i % 2 == 0){
                info.setAccountId(10000 + i);
            }

            infos.add(info);
        }

        List<Integer> accIds = new ArrayList<>();

        accIds = infos.stream().filter(bill -> null != bill.getAccountId()).map(BillInfo::getAccountId).collect(Collectors.toList());

        System.out.println(accIds);
    }

    static void testStringLength(){
        String name1 = "853b7531e174938dc1729bd95e5627bf_902fb1b90f033231b8d12819e952243_Expires%3D1713920319%26OSSAccessKeyId%3DLTAI5tBpCqpFiZF1ae4T9mTd%26Signature%3DB6%2BCKn7kES9D46hKO%2BKAb2A5eZE%3D.xlsx";
        String name2 = "超级无敌特别长几乎不可能%会出现的文件名称对应的代理商保%险额度导入模板 - 副本安东尼教案设计活动io；idajushflalhdui；年底话厚度啊u都好似较大是打算都还大多数阿斯哦对哈打死oh嗲东风超级无敌特别长几乎不可能%会出现的文件名称对应的代理商保%险额度导入模板阿斯哦对哈打死oh嗲东风超级无敌特别长几乎不可能%会出现的文件名称对应的代理商保%险额度导入模板.xlsx";
        String name3 = "jkadhjkasfjahdbskadjshdaskhudhedajldsjdaioadjlakdsjaksjdlgkjbfhgdjasbvkjbasdhnkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkfffffffffffffffffffffffffffffffffffffg.xlsx";
        System.out.println(name1.length());
        System.out.println(name2.length());
        System.out.println(name3.length());

        String[] nameStr = name1.split("%");
        for (int i = 0; i < nameStr.length; i++){
            System.out.println(nameStr[i]);
        }
    }

    static void testLongToInt(){
        Long l = 1763423782637212658l;
        Long l1 = 1763433337212658l;
        Long l2 = 1763455552637212658l;

        System.out.println((l.intValue()));
        System.out.println((l1.intValue()));
        System.out.println((l2.intValue()));
    }

    static void testFilter(){


        List<BillInfo> bills = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            BillInfo bill = new BillInfo();
            bill.setId(i + 1);
            bill.setName("账单" + (i+1));
            bill.setAccountId(1000 + (i+1));

            bills.add(bill);
        }


        List<BillInfo> matchedBills = new ArrayList<>();

        for (BillInfo bill : bills){
            if (ran.nextInt(3) == 0){
                matchedBills.add(bill);
            }
        }


        bills.get(0).setRuleLinkId(10086);

        for (BillInfo bill : matchedBills){
            System.out.println(bill.getRuleLinkId());
        }
    }

    static void testTrim(){
        String s = "10, 30";
        System.out.println(s.trim());
    }

    static void testSplit(boolean isNeedMultipleSearch, String str){
        if (isNeedMultipleSearch){
            str = str.replaceAll(" ", "");
            String[] arr = str.split(",");
            arr = Arrays.stream(arr).filter(mediumid -> mediumid!=null &&!"".equals(mediumid)).toArray(String[]::new);

            String cardNoSql = " and exists(select 1 from acc_deduct_detail a where a.batch_no = t.batch_no ";

            if (arr.length > 0){
                if (arr.length == 1){
                    cardNoSql += " and a.card_no like '%" + arr[0] + "%' ";
                }else {
                    cardNoSql += " '%" + arr[0] + "%' ";
                    for (int i = 1; i < arr.length; i++){
                        cardNoSql += " or a.card_no like '%" + arr[i] + "%'";
                    }
                }
            }

            System.out.println(cardNoSql);
        }else {
            //原逻辑
        }

        if (isNeedMultipleSearch){
            str = str.replaceAll(" ", "");
            String[] arr = str.split(",");
            arr = Arrays.stream(arr).filter(mediumid -> mediumid!=null &&!"".equals(mediumid)).toArray(String[]::new);

            if (arr.length > 0){
                if (arr.length == 1){
                    //原逻辑
                    System.out.println("原逻辑");
                }else {
                    String mediumSql = " t.mediumid like '%" + arr[0] + "%' ";
                    for (int i = 1; i < arr.length; i++){
                        mediumSql += " or t.mediumid like '%" + arr[i] + "%'";
                    }
                    System.out.println(mediumSql);
                }
            }
        }else {
            System.out.println("原逻辑");
        }
    }

    static void testSplit1(boolean isNeedMultipleSearch, String str){
        if (null != str && !"".equals(str)) {
            if (isNeedMultipleSearch) {
                //支持根据多个卡号模糊查询
                String mediumidSearch = str.replaceAll("，", ",").replaceAll(" ", "");//兼容中文逗号和空格
                String[] arr = mediumidSearch.split(",");
                arr = Arrays.stream(arr).filter(mediumid -> mediumid != null && !"".equals(mediumid)).toArray(String[]::new);

                if (arr.length > 0) {
                    if (arr.length == 1) {
                        //原逻辑
                        System.out.println("新逻辑，但只有一个：" + arr[0]);
                    } else {
                        String mediumSql = " t.mediumid like '%" + arr[0] + "%' ";
                        for (int i = 1; i < arr.length; i++) {
                            mediumSql += " or t.mediumid like '%" + arr[i] + "%'";
                        }
                        System.out.println(mediumSql);
                    }
                } else {
                    System.out.println("原逻辑");
                }
            }
        }
    }

    static void testSplit2(boolean isNeedMultipleSearch, String str){
        if (isNeedMultipleSearch){
            //支持根据多个卡号模糊查询
            String cardNoSearch = str.replaceAll("，",",").replaceAll(" ","");//兼容中文逗号和空格

            cardNoSearch = cardNoSearch.replaceAll(" ", "");
            String[] arr = cardNoSearch.split(",");
            arr = Arrays.stream(arr).filter(mediumid -> mediumid!=null &&!"".equals(mediumid)).toArray(String[]::new);

            String cardNoSql = " and exists(select 1 from acc_deduct_detail a where a.batch_no = t.batch_no ";

            if (arr.length > 0){
                if (arr.length == 1){
                    cardNoSql += " and a.card_no like '%" + arr[0] + "%' ";
                }else {
                    cardNoSql += " '%" + arr[0] + "%' ";
                    for (int i = 1; i < arr.length; i++){
                        cardNoSql += " or a.card_no like '%" + arr[i] + "%'";
                    }
                }
            }

            System.out.println(cardNoSql);
        }else {
            System.out.println("原逻辑");
        }
    }

    static void testSplit3(boolean isNeedMultipleSearch, String str){
        String where = "";
        if (isNeedMultipleSearch){
            //支持根据多个卡号模糊查询
            String mediumidSearch = str.replaceAll("，",",").replaceAll(" ","");//兼容中文逗号和空格
            String[] arr = mediumidSearch.split(",");
            arr = Arrays.stream(arr).filter(mediumid -> mediumid!=null &&!"".equals(mediumid)).toArray(String[]::new);

            if (arr.length > 0) {
                if (arr.length == 1) {
                    //原逻辑
                    where += " and t.mediumid like '%" + arr[0] + "%' ";
                } else {
                    where += " and (t.mediumid like '%" + arr[0] + "%' ";
                    for (int i = 1; i < arr.length; i++) {
                        where += " or t.mediumid like '%" + arr[i] + "%'";
                    }
                    where += ") ";
                }
            }
        }else {
            where += " and t.mediumid like '%" + str + "%'";
        }

        System.out.println(where);
    }

    static void testPositionSum(){
        int n = 10086;
        int sum = 0;

        while(n / 10 > 0 || n % 10 > 0){
            int p = n % 10;
            n /= 10;
            sum += p;
            System.out.println(p);
        }

        System.out.println(sum);
    }

    static void testBatchStringBuilder(Long batchNo){
        List<String> mediumIdList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            mediumIdList.add("ICBC_" + (i+1));
        }

        StringBuilder updateSqlBuilder = new StringBuilder();

        int count = 0;
        int countCycle = 20;

        for (int i = 0; i < mediumIdList.size(); i++){
            String mediumId = mediumIdList.get(i);

            if (count == 0){
                updateSqlBuilder.append("update icbc_accountopen set prtlbatchno = " + batchNo +" where mediumid in ('");
            }

            updateSqlBuilder.append(mediumId + "','");
            count++;

            if (count % countCycle == 0 || i >= mediumIdList.size() - 1){
                updateSqlBuilder.append(mediumId + "');");
                count = 0;
            }
        }

        System.out.println(updateSqlBuilder.toString());
    }

    static void testGetStandardfee(Integer settleVersion, BigDecimal standardfee){
        BillInfo bill = new BillInfo();
        bill.setSettleversion(settleVersion);
//        bill.setStandardfee(standardfee);
        Map<Integer, Object> valMap = new HashMap<>();

        if(null != bill.getSettleversion() && bill.getSettleversion() == 20){
            valMap.put(12, bill.getStandardfee()); //费用标准
            System.out.println(valMap.get(12));
        }else {
            System.out.println("原逻辑");
        }
    }

    static void testChar(){
        char a = 'B';
        System.out.println(a-'A');

        Integer i = 2;
        System.out.println((char)('A' + i - 1));
    }

    static int testIntervalDays(String startDateStr, String endDateStr, String fmt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);

        Date startdate = sdf.parse(startDateStr);
        Date enddate = sdf.parse(endDateStr);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startdate);
        long time1 = cal.getTimeInMillis();

        cal.setTime(enddate);
        long time2 = cal.getTimeInMillis();

        long days = (time2 - time1) / (24 * 3600 * 1000);
        return (int) days;
    }

    static void testHashMapInitSize() throws ParseException {
        Map<Integer, String> map = new HashMap<>(16);

        for (int i = 0; i < 20; i++){
            map.put(i, i * 10086 + "");
        }

        for (Integer i : map.keySet()){
            System.out.println(map.get(i));
        }
    }

    static void testMinusDate(){
        LocalDate now = LocalDate.now();

        LocalDate minusWeek = now.minusWeeks(1l);

        LocalDate minusMonth = now.minusMonths(1l);

        LocalDate minusThreeMonths = now.minusMonths(3l);

        System.out.println(now.toString());
        System.out.println(minusWeek.toString());
        System.out.println(minusMonth.toString());
        System.out.println(minusThreeMonths.toString());
    }

    static void testInStringLength(){
        StringBuilder sb = new StringBuilder();

        for (int i = 10000000; i < 10000000+10000; i++){
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    };

    static void testIntegerCompare(){
        Integer a = 15678;
        Integer b = null;
        if (a.compareTo(b) > 0){
            System.out.println("可以");
        }
    };

    static void testIntegerCompare1(){
        Integer a = 5000;
        Integer b = 5000;

        System.out.println(a==b);
    }

    static void testCaught(){
        Integer a = 5000;

        try{
            a = a/0;

            System.out.println("报错之后");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("捕获了");
        }



        System.out.println("giao");
    }

    static void testDivide(){
        Integer a = 5;
        Integer b = 6;

        BigDecimal rate = new BigDecimal((a * 100 / b));

        System.out.println(rate.toString());
    }

    static void testBreak(){
        String str = "你有这么高速运转的机器进入中国记住我给出的原理小的时候，为什么说\n\r\n意大利面就要拌26号混凝土";
        String str1 = "你有这么高速运转的机器进入中国记住我给出的原理小的时候，为什么说意大利面就要拌26号混凝土";
        String str2 = "1）在晶澳公司正式验收之前，代理商应先完成自查及整改工作；<br>2）针对电站施工与北京晶澳公司标准吻合度，结构安全、电气安全等方面进行线下检查。\\n3）与《附件1：晶澳户用光伏电站质量验收评定表》一并作为附件上传至晶澳兴家系统。\\n4）本报告使用流程：\n" +
                "①晶澳验收人员完成报告，并下发给代理商； ②代理商相关人员完成电站整改，回传报告； ③晶澳验收人员核验结果。";

        String[] array = str.split("\n");

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
            System.out.println("giao");
        }
    }

    static void testReplace(){
        String a = "广东省广州市天河区马应龙";
        String b = "广东省广州市天河区";

        String c = a.replace(b, "");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    static void testBuilder(){
        BillInfo b = new BillInfo();
        b.setId(1);
        b.setName("111");
        b.setAccountId(null);

        StringBuilder sb = new StringBuilder();

        sb.append(b.getId());
        sb.append(",");
        sb.append(b.getName());
        sb.append(",");
        sb.append(b.getAccountId());
        sb.append(",");

        System.out.println(sb.toString());

    }

    static void testQuickSort(){
        int[] nums = {1,23,44,55,34,57,83,435,43,5,346,45234,38,3423,4,324};

        sortPart(0, nums.length - 1, nums);


    }
    static void sortPart(int l, int r, int[] nums){
        if (l >= r){
            return;
        }

        int pivot = nums[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j){
            while(nums[i] > pivot){
                i ++ ;
            }
            while(nums[j] < pivot){
                j--;
            }

            if (i <= j){
                swap(i, j, nums);
                i++;
                j--;
            }

        }

        sortPart(l, j, nums);
        sortPart(i, r, nums);
    }

    private static void printArray(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            if (sb.length() == 0){
                sb.append(nums[i]);
            }else {
                sb.append(",").append(nums[i]);
            }
        }
        System.out.println(sb.toString());
    }

    private static void swap(int lf, int rf, int[] nums) {
        int tmp = nums[lf];
        nums[lf] = nums[rf];
        nums[rf] = tmp;
    }

    private static void testEmptyArrayStream(){
        List<Integer> array = new ArrayList<>();

        array.forEach(item -> {
            System.out.println("giao");
        });
    }

    /*static void quickSort(int l, int r, int[] nums) {
        if (l >= r) return;
        int pivot = nums[(l + r) / 2]; // 或随机选择
        int i = l, j = r;
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                swap(i, j, nums);
                printArray(nums);
                i++;
                j--;
            }
        }
        quickSort(l, j, nums);
        quickSort(i, r, nums);
    }*/

    static void testChangeShort(){
        System.out.println((short) 11.5);
    }

    static void printBinaryString(int n){
        System.out.println(Integer.toBinaryString(n));
    }
}



class BillInfo{
    private Integer id;
    private String name;
    private Integer accountId;

    private Integer ruleLinkId;

    private BigDecimal standardfee;
    private Integer settleversion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRuleLinkId() {
        return ruleLinkId;
    }

    public void setRuleLinkId(Integer ruleLinkId) {
        this.ruleLinkId = ruleLinkId;
    }

    public BigDecimal getStandardfee() {
        return standardfee;
    }

    public void setStandardfee(BigDecimal standardfee) {
        this.standardfee = standardfee;
    }

    public Integer getSettleversion() {
        return settleversion;
    }

    public void setSettleversion(Integer settleversion) {
        this.settleversion = settleversion;
    }
}
