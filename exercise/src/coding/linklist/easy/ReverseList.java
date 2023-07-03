package coding.linklist.easy;

/**
 * @ClassNAME ReverseList
 * @Description 反转链表
 * @Author yu
 * @Date 2023/6/29 10:55
 * @Version 1.0
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseList r = new ReverseList();
        ListNode.printNode(r.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
