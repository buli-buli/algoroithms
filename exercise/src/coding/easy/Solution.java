package coding.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2);

        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        TreeNode root = builder.buildTree(values);

        Solution solution = new Solution();
        int diameter = solution.diameterOfBinaryTree(root);

        System.out.println(diameter);  // 输出结果
    }
}



class BinaryTreeBuilder {
    public TreeNode buildTree(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.size()) {
            TreeNode current = queue.poll();
            if (values.get(i) != null) {
                current.left = new TreeNode(values.get(i));
                queue.add(current.left);
            }
            i++;
            if (i < values.size() && values.get(i) != null) {
                current.right = new TreeNode(values.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
