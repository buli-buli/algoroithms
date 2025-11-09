package coding.bzc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2025年01月08日
 */
public class FileDownLoadTest {
    public static void downloadFile(String fileUrl, String destinationFilePath) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            // 创建 URL 对象
            URL url = new URL(fileUrl);

            // 打开连接
            URLConnection connection = url.openConnection();

            // 获取输入流
            inputStream = connection.getInputStream();

            // 创建输出流，指定文件的保存路径
            outputStream = new FileOutputStream(destinationFilePath);

            byte[] buffer = new byte[4096];
            int bytesRead;

            // 读取输入流并写入输出流（文件）
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("文件下载完成！保存路径：" + destinationFilePath);

        } catch (IOException e) {
            System.out.println("下载文件时发生错误: " + e.getMessage());
        } finally {
            // 关闭流
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadFile1(String fileUrl, String destinationFilePath) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            String beforUrl = fileUrl;// 整改前图片 url

            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (null != connection){
                try(InputStream is = connection.getInputStream();) {
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                        // 创建输出流，指定文件的保存路径
                        outputStream = new FileOutputStream(destinationFilePath);

                        byte[] buffer = new byte[4096];
                        int bytesRead;

                        // 读取输入流并写入输出流（文件）
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.out.println("下载文件时发生错误: " + e.getMessage());
        } finally {
            // 关闭流
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 示例文件 URL 和保存的本地路径
        String fileUrl = "https://jasolarprod.oss-cn-beijing.aliyuncs.com/group/2025-01-08-09/60cf9a4b-71b2-4f08-9961-53496a65e97a.docx?Expires\\u003d1736386638\\u0026OSSAccessKeyId\\u003dLTAI5tKybM65hgDUiKqdLuTk\\u0026Signature\\u003dGXvV8lPQoQP00CP%2B5DBXmpxWlfQ%3D";
        String fileUrl1 = "";

        String destinationFilePath = "C://Users//yuyuyu//Desktop/1.docx";

        // 调用下载方法
        downloadFile(fileUrl, destinationFilePath);
    }
}
