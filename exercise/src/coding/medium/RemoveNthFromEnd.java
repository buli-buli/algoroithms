package coding.medium;

/**
 * @ClassNAME RemoveNthFromEnd
 * @Description 删除链表的倒数第 N 个结点
 * @Author yu
 * @Date 2023/6/25 16:53
 * @Version 1.0
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }

        int index = count - n;

        if (index == 0) {
            return head.next;
        }

        int i = 0;
        ListNode prev = null;
        curr = head;
        while(i < index){
            prev = curr;
            curr = curr.next;
            i++;
        }

        prev.next = curr.next;

        printListNode(head);
        return head;
    }

    public static void printListNode(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthFromEnd r = new RemoveNthFromEnd();

        r.removeNthFromEnd(head, 2);
    }
}
