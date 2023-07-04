package coding.tree.easy;

/**
 * @ClassNAME IsSameTree
 * @Description 相同的树
 * @Author yu
 * @Date 2023/7/3 13:13
 * @Version 1.0
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q){
            return true;
        }

        if (null == q && null != p){
            return false;
        }
        if (null == p && null != q){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);

        if (!l || !r){
            return false;
        }

        return true;
    }
}
