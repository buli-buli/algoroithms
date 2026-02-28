package coding.dynamic.medium;

/**
 * @author yzw
 * @Description 337、打家劫舍 Ⅲ
 * @createTime 2026年02月28日
 */
public class RobThree {
    public static void main(String[] args) {
        System.out.println(rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
        System.out.println(rob(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)))));
        System.out.println(rob(new TreeNode(4,new TreeNode(1,new TreeNode(2,new TreeNode(3),null),null),null)));
    }

    static int rob(TreeNode root) {
        int dp[] = getDp(root);

        return Math.max(dp[0], dp[1]);
    }

    static int[] getDp(TreeNode root) {
        if (root == null){
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null){
            return new int[]{root.val, 0};
        }

        int[] left = getDp(root.left);

        int[] right = getDp(root.right);

        return new int[]{root.val + left[1] + right[1], Math.max(left[0],left[1]) + Math.max(right[0], right[1])};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
