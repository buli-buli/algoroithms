package coding.tree.easy;

/**
 * @ClassNAME SumOfLeftLeaves
 * @Description 左叶子之和
 * @Author yu
 * @Date 2023/7/3 15:28
 * @Version 1.0
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if (root == null){
            return 0;
        }

        if (null != root.left && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
