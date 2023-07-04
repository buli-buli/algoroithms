package coding.tree.easy;

/**
 * @ClassNAME MinDepth
 * @Description 二叉树的最小深度
 * @Author yu
 * @Date 2023/7/3 13:51
 * @Version 1.0
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    public static int getDepth(TreeNode root, int depth){
        if (null == root){
            return depth;
        }

        if (null == root.left){
            return getDepth(root.right, depth) + 1;
        }else if (null == root.right){
            return getDepth(root.left, depth) + 1;
        }else {
            return Math.min(getDepth(root.left, depth), getDepth(root.right, depth)) + 1;
        }
    }
}
