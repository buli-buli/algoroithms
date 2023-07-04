package coding.tree.medium;

/**
 * @ClassNAME InorderSuccessor
 * @Description 二叉搜索树中的中序后继
 * @Author yu
 * @Date 2023/7/3 16:48
 * @Version 1.0
 */
public class InorderSuccessor {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{2,1,3} ;
        TreeNode root = BinaryTreeConstruction.constructBinaryTree(nums);

        InorderSuccessor i = new InorderSuccessor();
        System.out.println(i.inorderSuccessor(root, root.left).val);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (null != p.right){
            return treeMinimum(p.right);
        }

        return getSuccessorFromleft(root, p);
    }

    public TreeNode treeMinimum(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public TreeNode getSuccessorFromleft(TreeNode root, TreeNode p){
        TreeNode successor = null;
        while(root != null){
            if (root.val > p.val){
                successor = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }

        return successor;
    }
}
