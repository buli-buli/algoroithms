package coding.easy;

/**
 * @ClassNAME IsSymmetric
 * @Description 对称二叉树
 * @Author yu
 * @Date 2023/8/7 16:02
 * @Version 1.0
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        return q.val == p.val && check(q.left, p.right) && check(q.right, p.left);
    }
}
/**
 * Definition for a binary tree node.
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
