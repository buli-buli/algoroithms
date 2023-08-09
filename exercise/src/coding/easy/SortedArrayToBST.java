package coding.easy;

/**
 * @ClassNAME SortedArrayToBST
 * @Description 将有序数组转换为二叉搜索树
 * @Author yu
 * @Date 2023/8/7 16:24
 * @Version 1.0
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0, r = nums.length - 1;

        return generate(nums, l, r);
    }

    private TreeNode generate(int[] nums, int l, int r) {
        if (l > r){
            return null;
        }

        int mid = (l + r + 1) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = generate(nums, l, mid - 1);
        node.right = generate(nums, mid + 1, r);

        return node;
    }
}
