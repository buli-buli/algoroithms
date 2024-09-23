package coding.easy;

import coding.model.TreeNodeCommon;
import coding.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
    int res = 0;
    public static void main(String[] args) {
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();

//        TreeNodeCommon node1 = new TreeNodeCommon(1);
//        node1.left = new TreeNodeCommon(2);
//        node1.right = new TreeNodeCommon(3);
//        node1.left.left = new TreeNodeCommon(4);
//        node1.left.right = new TreeNodeCommon(5);
//
//        TreeNodeCommon node2 = new TreeNodeCommon(1);
//        node2.left = new TreeNodeCommon(2);
//
//        TreeNodeCommon node3 = new TreeNodeCommon(4);

        Integer[] array = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
        TreeNodeCommon root = TreeUtils.constructTree(array);



        TreeUtils.show(root);

        System.out.println(d.diameterOfBinaryTree(root));
    }

//    public int diameterOfBinaryTree(TreeNodeCommon root) {
//        int l = depth(root.left);
//        int r = depth(root.right);
//
//        return r + l;
//    }
//
//    public int depth(TreeNodeCommon root) {
//        if (null == root){
//            return 0;
//        }
//
//        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
//    }

    public int diameterOfBinaryTree(TreeNodeCommon root) {
        res = 0;
        depth(root);

        return res - 1;
    }

    public int depth(TreeNodeCommon root) {
        if (null == root){
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        res = Math.max(res, l + r + 1);

        return Math.max(l, r) + 1;
    }
}