package coding.medium;

import java.util.List;

/**
 * @ClassNAME RotateRIght
 * @Description 旋转链表
 *       给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Author yu
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RotateRight r = new RotateRight();
        ListNode.printNode(r.rotateRight(head, 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;

        int size = 0;

        //1、遍历一遍算出链表大小
        while (tail != null && tail.next != null){
            size++;
            tail = tail.next;
        }
        size = size + 1;

        //特殊情况处理：数组为空或数组长度只有一个
        if (size == 0 || size == 1){
            return head;
        }

        //2、直接成环
        tail.next = head;

        //根据k计算出旋转后头节点位置
        int flag = size - k % size;
        int i = 1;
        while (i < flag){
            head = head.next;
            i++;
        }

        //3、断开旋转后头节点与前一个节点的链接
        ListNode cut = head;
        head = head.next;
        cut.next = null;

        return head;
    }
}
