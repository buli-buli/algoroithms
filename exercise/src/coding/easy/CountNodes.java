package coding.easy;

/**
 * @author yzw
 * @Description 完全二叉树的节点个数
 * @createTime 2024年09月23日
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (null == root){
            return 0;
        }
        if (null == root.left && null == root.right){
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
