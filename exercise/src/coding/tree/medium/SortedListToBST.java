package coding.tree.medium;

/**
 * @ClassNAME SortedListToBST
 * @Description 有序链表转换二叉搜索树
 * @Author yu
 * @Date 2023/7/3 14:46
 * @Version 1.0
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right){
        if (left == right){
            return null;
        }
        ListNode middle = getMiddleNode(left, right);

        TreeNode root = new TreeNode(middle.val);

        root.left = buildTree(left, middle);
        root.right = buildTree(middle.next, right);

        return root;
    }

    public ListNode getMiddleNode(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;

        while(fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printNode(ListNode res){
        while(res != null){
            if (res.next != null){
                System.out.print(res.val + "->");
            }else {
                System.out.print(res.val);
            }

            res = res.next;
        }
        System.out.println();
    }
}