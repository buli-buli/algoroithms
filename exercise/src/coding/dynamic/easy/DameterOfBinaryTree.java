package coding.dynamic.easy;

import coding.MyUtil;
import coding.TreeNode;

/**
 * @author yzw
 * @Description 543、二叉树的直径
 * @createTime 2026年02月28日
 */
public class DameterOfBinaryTree {
    private static int max = 0;

    public static void main(String[] args) {
        //System.out.println(diameterOfBinaryTree(MyUtil.buildTree(new Integer[]{1,2,3,4,5})));
        //System.out.println(diameterOfBinaryTree(MyUtil.buildTree(new Integer[]{4})));
        //System.out.println(diameterOfBinaryTree(MyUtil.buildTree(new Integer[]{2,3,null,1})));
        //System.out.println(diameterOfBinaryTree(MyUtil.buildTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2})));
        System.out.println(diameterOfBinaryTree(MyUtil.buildTree(new Integer[]{1,2})));



        //depth(MyUtil.buildTree(new Integer[]{1,2,3,4,null,5,6,7,8,null,9,null,null,null,null,10,null,null,11}));
        //depth(MyUtil.buildTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2}));


        //dfs(MyUtil.buildTree(new Integer[]{1,2,3,4,null,5,6,7,8,null,9,null,null,null,null,10,null,null,11}));
    }

    static int diameterOfBinaryTree(TreeNode root) {
        max = 0;

        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 0;
        }

        int rootDepth = depth(root.left) + depth(root.right);

        return Math.max(rootDepth, max);
    }

    static int depth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        max = Math.max(max, l + r);

        int diameter = Math.max(l, r) + 1;
        //System.out.println(root.val + ": " + diameter + "; (l + r):  " + (l + r));
        return diameter;
    }


    static void dfs(TreeNode root) {
        if (root == null){
            return;
        }

        dfs(root.left);
        dfs(root.right);

        System.out.println(root.val);
    }
}

