package coding.tree.easy;

/**
 * @ClassNAME MaxDepth
 * @Description 二叉树的最大深度
 * @Author yu
 * @Date 2023/7/3 14:34
 * @Version 1.0
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (null == root){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
