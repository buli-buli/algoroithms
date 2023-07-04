package coding.tree.medium;

/**
 * @ClassNAME VerifyPostorder
 * @Description 二叉搜索树的后序遍历序列
 * @Author yu
 * @Date 2023/7/3 15:49
 * @Version 1.0
 */
public class VerifyPostorder {
    public static void main(String[] args) {
        int[] postorder = new int[]{4, 8, 6, 12, 16, 14, 10};

        VerifyPostorder v = new VerifyPostorder();
        System.out.println(v.verifyPostorder(postorder));
    }
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postorder, int l, int r){
        if (l >= r){
            return true;
        }

        int m = l;
        while (postorder[m] < postorder[r]){
            m++;
        }

        for (int i = m; i < r; i++){
            if (postorder[i] < postorder[r]){
                return false;
            }
        }

        return verify(postorder, l, m - 1) && verify(postorder, m + 1, r - 1);
    }
}
