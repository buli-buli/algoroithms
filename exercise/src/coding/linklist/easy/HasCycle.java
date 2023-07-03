package coding.linklist.easy;

/**
 * @ClassNAME HasCycle
 * @Description 141.环形链表
 * @Author yu
 * @Date 2023/6/29 9:32
 * @Version 1.0
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cycleEnd = new ListNode(2);
        head.next = cycleEnd;
        cycleEnd.next = new ListNode(0);
        cycleEnd.next.next = new ListNode(-4);
        cycleEnd.next.next.next = cycleEnd;

        HasCycle h = new HasCycle();
        System.out.println(h.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;

        while(slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}

