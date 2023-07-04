package coding.tree.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME PreorderTraversal
 * @Description 二叉树的前序遍历
 * @Author yu
 * @Date 2023/7/3 11:50
 * @Version 1.0
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        traversal(root, res);

        return res;
    }

    public void traversal(TreeNode root, List<Integer> res){
        if (null == root){
            return;
        }

        res.add(root.val);
        traversal(root.left, res);
        traversal(root.right, res);
    }
}


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
