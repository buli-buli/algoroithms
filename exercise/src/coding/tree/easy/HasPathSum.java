package coding.tree.easy;

/**
 * @ClassNAME HasPathSum
 * @Description 路径总和
 * @Author yu
 * @Date 2023/7/3 14:20
 * @Version 1.0
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
