package coding.bzc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogStationFilter {
    public static void main(String[] args) {
        // 替换为你的 .log 文件路径
        String logFilePath = "D://BrowserDownload/crm-center.2025-11-08.0.log";

        // 正则：匹配整行，并捕获中间的数字编号
        // \\s+ 表示一个或多个空白字符（空格、制表符等）
        Pattern pattern = Pattern.compile("开始匹配电站\\s+(\\d+)\\s+投资方间隔周期规则");

        List<String> stationNumbers = new ArrayList<>(); // 用于存储所有编号

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String stationNo = matcher.group(1); // 提取括号内的编号
                    stationNumbers.add(stationNo);
                    sb.append(stationNo).append(",");
                }
            }

            if (sb.length() > 0){
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
            }

        } catch (IOException e) {
            System.err.println("❌ 读取文件失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}