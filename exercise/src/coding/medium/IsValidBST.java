package coding.medium;


import coding.model.TreeNodeCommon;

/**
 * @author yzw
 * @Description 验证二叉搜索树
 * @createTime 2024年11月12日
 */
public class IsValidBST {
    //抄的
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, Long min, Long max){
        if (null == node){
            return true;
        }

        if (node.val <= min || node.val >= max){
            return false;
        }

        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}
class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
