package coding.tree.easy;

/**
 * @ClassNAME InvertTree
 * @Description  翻转二叉树
 * @Author yu
 * @Date 2023/7/3 11:58
 * @Version 1.0
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;
    }

    public void invert(TreeNode root){
        if (null == root){
            return;
        }
        //存储左孩子和右孩子节点
        TreeNode l = root.left;
        TreeNode r = root.right;

        //反转左孩子和右孩子
        root.left = r;
        root.right = l;

        //递归调用反转左子树和右子树
        invert(root.left);
        invert(root.right);
    }
}
