package coding.bzc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractIdNameToSQLFile {

    public static void main(String[] args) {
        String inputFilePath = "D://a.txt";      // 输入的 TXT 文件路径
        String outputFilePath = "D://tmp.sql";   // 输出的 SQL 文件路径

        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // 正则：匹配包含 ID="..." 和 name="..." 的标签（顺序无关）
            Pattern pattern = Pattern.compile(
                "<\\w+\\s+" +
                "(?=.*?ID\\s*=\\s*\"([^\"]+)\")" +
                "(?=.*?name\\s*=\\s*\"([^\"]+)\")" +
                "[^>]*>"
            );
            Matcher matcher = pattern.matcher(content);

            StringBuilder insertValues = new StringBuilder();

            while (matcher.find()) {
                String id = matcher.group(1).trim();
                String name = matcher.group(2).trim().replace("'", "''"); // 转义单引号
                if (insertValues.length() > 0) {
                    insertValues.append(",\n");
                }
                insertValues.append(String.format("  ('%s', '%s')", id, name));
            }

            // 构建完整 SQL 脚本
            StringBuilder sqlScript = new StringBuilder();
            sqlScript.append("-- 自动从 a.txt 提取 ID 和 name 生成的临时表脚本\n")
                     .append("DROP TABLE IF EXISTS tmp;\n\n")
                     .append("CREATE TABLE tmp (\n")
                     .append("  id VARCHAR(64) NOT NULL,\n")
                     .append("  name VARCHAR(255) NOT NULL\n")
                     .append(");\n\n");

            if (insertValues.length() > 0) {
                sqlScript.append("INSERT INTO tmp (id, name) VALUES\n")
                         .append(insertValues)
                         .append(";\n");
            }

            // 写入文件
            Files.write(Paths.get(outputFilePath), sqlScript.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("✅ SQL 脚本已成功生成并保存到: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("❌ 文件处理失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}