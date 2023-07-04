package coding.tree.medium;

public class BinaryTreeConstruction {
    public static TreeNode constructBinaryTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructTreeHelper(nums, 0);
    }

    private static TreeNode constructTreeHelper(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = constructTreeHelper(nums, 2 * index + 1);
        node.right = constructTreeHelper(nums, 2 * index + 2);

        return node;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root = constructBinaryTree(nums);
        // 可以对构造出来的二叉树进行其他操作或遍历验证
    }
}