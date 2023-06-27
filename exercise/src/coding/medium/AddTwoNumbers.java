package coding.medium;

import java.util.List;

/**
 * @ClassNAME AddTwoNumbers
 * @Description 两数相加
 * @Author yu
 * @Date 2023/6/25 18:50
 * @Version 1.0
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode res = a.addTwoNumbers(l1,l2);
        printListNode(res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;

        int a,b;
        boolean isPush = false;
        while(l1 != null || l2 != null){
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;

            int sum = a + b;

            if (isPush){
                sum += 1;
                isPush = false;
            }

            if (sum / 10 >= 1){
                isPush = true;
                sum %= 10;
            }

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }

        if (isPush){
            cur.next = new ListNode(1);
        }
        return res.next;
    }

    public static void printListNode(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
