package coding.linklist.medium;

/**
 * @ClassNAME DetectCycle
 * @Description 环形链表 II
 * @Author yu
 * @Date 2023/6/30 11:23
 * @Version 1.0
 */
public class DetectCycle {
    public static void main(String[] args) {
        DetectCycle d = new DetectCycle();

        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = node;

        ListNode.printNode(d.detectCycle(head), 4);
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head.next;

        while(slow != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
