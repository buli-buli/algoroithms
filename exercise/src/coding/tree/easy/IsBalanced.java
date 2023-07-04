package coding.tree.easy;

/**
 * @ClassNAME IsBalanced
 * @Description 平衡二叉树
 * @Author yu
 * @Date 2023/7/3 13:24
 * @Version 1.0
 */
public class IsBalanced {
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,null,null,3,4,null,null,4};
        TreeNode root = BinaryTreeConstruction.constructBinaryTree(nums);
        IsBalanced i =new IsBalanced();
        System.out.println(i.isBalanced(root));
    }
    public boolean isBalanced(TreeNode root) {
        if (null == root){
            return true;
        }

        //定义递归函数计算层数，如果是平衡树正常返回层数，如果不是平衡树返回-1
        int num = layer(root);

        if (-1 == num){
            return false;
        }else {
            return true;
        }
    }

    private int layer(TreeNode root) {
        if (null == root){
            return 0;
        }

        //计算左孩子层数
        int lNum = layer(root.left);
        //计算右孩子层数
        int rNum = layer(root.right);

        if (-1 == lNum || -1 == rNum){
            //如果左右孩子中有一个不是平衡树，直接返回-1
            return -1;
        }

        if (Math.abs(lNum - rNum) > 1){
            return -1;
        }else {
            return Math.max(lNum, rNum) + 1;
        }
    }

}
