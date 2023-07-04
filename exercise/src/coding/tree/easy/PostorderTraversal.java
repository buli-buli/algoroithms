package coding.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME PostorderTraversal
 * @Description 二叉树的后序遍历
 * @Author yu
 * @Date 2023/7/3 11:56
 * @Version 1.0
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        traversal(root, res);

        return res;
    }

    public void traversal(TreeNode root, List<Integer> res){
        if (null == root){
            return;
        }

        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }
}
