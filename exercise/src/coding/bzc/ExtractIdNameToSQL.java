package coding.bzc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractIdNameToSQL {

    public static void main(String[] args) {
        String filePath = "D://a.txt"; // 替换为你的实际路径

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // 正则匹配所有包含 ID="..." name="..." 的标签
            Pattern pattern = Pattern.compile("<\\w+\\s+[^>]*ID\\s*=\\s*\"([^\"]+)\"[^>]*name\\s*=\\s*\"([^\"]+)\"[^>]*>");
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

            // 构建完整的建表 + 插入语句（仅建表脚本按题目要求）
            String createTableScript = 
                "CREATE TABLE tmp (\n" +
                "  id VARCHAR(64) NOT NULL,\n" +
                "  name VARCHAR(255) NOT NULL\n" +
                ");";

            System.out.println(createTableScript);

            // 可选：如果你也想要插入语句（调试用），可以取消下面注释
            if (insertValues.length() > 0) {
                String insertScript = "\nINSERT INTO tmp (id, name) VALUES\n" + insertValues + ";";
                System.out.println(insertScript);
            }

        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
        }
    }
}