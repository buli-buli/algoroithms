package coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
}
