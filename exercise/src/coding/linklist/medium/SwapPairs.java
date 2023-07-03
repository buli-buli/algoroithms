package coding.linklist.medium;

/**
 * @ClassNAME SwapPairs
 * @Description  两两交换链表中的节点
 * @Author yu
 * @Date 2023/6/30 9:40
 * @Version 1.0
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        SwapPairs s = new SwapPairs();
        ListNode.printNode(s.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = head;

        while(curr != null && curr.next != null){
            ListNode next = curr.next;

            curr.next = next.next;
            next.next = curr;
            prev.next = next;

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
