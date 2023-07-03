package coding.linklist.medium;

import java.util.List;

/**
 * @ClassNAME ReverseBetween
 * @Description  反转链表 II
 * @Author yu
 * @Date 2023/6/30 11:50
 * @Version 1.0
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ReverseBetween r = new ReverseBetween();
        ListNode.printNode(r.reverseBetween(head, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //新建一个哑节点
        ListNode dummy = new ListNode(0);
        //指向head
        dummy.next = head;

        //计算反转开始的位置，即下标小于left的第一个元素
        int i = 1;
        ListNode prefix = dummy;
        while(i < left){
            prefix = prefix.next;
            i++;
        }

        //反转下标在left-right之间的元素
        ListNode prev = null;
        ListNode curr = prefix.next;
        while (i <= right){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        //prefix.next.next此时指向的还是一个null节点，让它指向curr，此时curr存储的是下标大于right的第一个元素
        prefix.next.next = curr;
        //prev此时存储的是需反转区间的最后一个元素
        prefix.next = prev;

        return dummy.next;
    }
}
