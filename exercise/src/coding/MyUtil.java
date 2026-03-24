package coding;

import java.util.*;

/**
 * @author yzw
 * @Description TODO
 * @createTime 2026年02月03日
 */
public class MyUtil {
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void printCharArray(char[][] arr) {
        for (char[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            TreeNode node = queue.poll();

            // 处理左孩子
            if (index < arr.length && arr[index] != null) {
                node.left = new TreeNode(arr[index]);
                queue.offer(node.left);
            }
            index++;

            // 处理右孩子
            if (index < arr.length && arr[index] != null) {
                node.right = new TreeNode(arr[index]);
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }

    /**
     * 将形如 [["1","0",...],...] 的字符串解析为 char[][]
     *
     * @param input 格式：[["1","0","1","0","0"],["1","0","1","1","1"],...]
     * @return 对应的 char[][] 矩阵
     * @throws IllegalArgumentException 如果格式非法
     */
    public static char[][] parseStringMatrix(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new char[0][0];
        }

        String s = input.trim();
        if (!s.startsWith("[") || !s.endsWith("]")) {
            throw new IllegalArgumentException("Invalid format: must start with [ and end with ]");
        }

        // 去掉最外层 []
        s = s.substring(1, s.length() - 1).trim();
        if (s.isEmpty()) {
            return new char[0][0];
        }

        // 按 "],[" 分割行（注意可能有空格）
        // 使用正则分割，兼容空格：],\s*\[
        String[] rowStrings = s.split("\\],\\s*\\[");

        char[][] matrix = new char[rowStrings.length][];

        for (int i = 0; i < rowStrings.length; i++) {
            String row = rowStrings[i].trim();
            // 清理可能残留的 [ 或 ]
            row = row.replaceFirst("^\\[", "").replaceFirst("\\]$", "").trim();

            if (row.isEmpty()) {
                matrix[i] = new char[0];
                continue;
            }

            // 提取所有 "..." 中的内容
            List<Character> chars = new ArrayList<>();
            // 匹配所有 \"([^\"]*)\" 形式的字符串
            java.util.regex.Matcher m = java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(row);
            while (m.find()) {
                String val = m.group(1);
                if (val.length() != 1) {
                    throw new IllegalArgumentException("Each element must be a single character, got: \"" + val + "\"");
                }
                chars.add(val.charAt(0));
            }

            if (chars.isEmpty()) {
                throw new IllegalArgumentException("No valid elements found in row: " + row);
            }

            matrix[i] = new char[chars.size()];
            for (int j = 0; j < chars.size(); j++) {
                matrix[i][j] = chars.get(j);
            }
        }

        return matrix;
    }
}
