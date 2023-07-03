package coding.linklist.easy;

/**
 * @ClassNAME RemoveElements
 * @Description 移除链表元素
 * @Author yu
 * @Date 2023/6/29 10:32
 * @Version 1.0
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        RemoveElements r = new RemoveElements();
        int val = 2;
        ListNode.printNode(r.removeElements(head, val));
    }

    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }

        ListNode flag = head;

        while(flag != null && flag.next != null){
            if (flag.next.val == val){
                if (flag.next.next != null){
                    flag.next = flag.next.next;
                }else {
                    flag.next = null;
                }
            }else {
                flag = flag.next;
            }
        }

        return head;
    }
}
