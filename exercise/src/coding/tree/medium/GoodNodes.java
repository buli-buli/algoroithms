package coding.tree.medium;

import java.util.List;

/**
 * @ClassNAME GoodNodes
 * @Description 统计二叉树中好节点的数目
 * @Author yu
 * @Date 2023/8/25 19:08
 * @Version 1.0
 */
public class GoodNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        GoodNodes g = new GoodNodes();
        System.out.println(g.goodNodes(root));
    }
    public int goodNodes(TreeNode root) {
        return traversal(root, Integer.MIN_VALUE);
    }

    public int traversal(TreeNode root, int max){
        int ans = 0;

        if (null == root){
            return 0;
        }

        if (root.val >= max){
            ans++;
            max = root.val;
        }

        ans += traversal(root.left, max) + traversal(root.right, max);

        return ans;
    }
}
