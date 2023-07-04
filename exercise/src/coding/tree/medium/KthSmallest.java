package coding.tree.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME KthSmallest
 * @Description 二叉搜索树中第K小的元素
 * @Author yu
 * @Date 2023/7/4 9:31
 * @Version 1.0
 */
public class KthSmallest {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,1,4,null,2} ;
        TreeNode root = BinaryTreeConstruction.constructBinaryTree(nums);
        KthSmallest k = new KthSmallest();

        System.out.println(k.kthSmallest(root, 1));
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        traverse(root, k, elements);

        return elements.get(k - 1);
    }

    public void traverse(TreeNode root, int k, List<Integer> elements){
        if (null == root){
            return;
        }
        traverse(root.left, k, elements);
        elements.add(root.val);
        if (elements.size() >= k){
            return;
        }
        traverse(root.right, k, elements);

        return;
    }
}
