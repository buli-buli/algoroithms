package coding.linklist.medium;

import java.util.Stack;

/**
 * @ClassNAME AddTwoNumbers
 * @Description 两数相加 II
 * @Author yu
 * @Date 2023/7/4 11:25
 * @Version 1.0
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode.printNode(a.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        Stack shorter;
        Stack longer;
        if (s1.size() > s2.size()){
            longer = s1;
            shorter = s2;
        }else {
            longer = s2;
            shorter = s1;
        }

        boolean isPush = false;
        ListNode res = null;
        while(!longer.empty()){
            Integer sum = (Integer) longer.pop();
            if (!shorter.empty()){
                sum += (Integer) shorter.pop();
            }

            if (isPush){
                sum+=1;
            }
            if (sum >= 10){
                isPush = true;
                sum %= 10;
            }else {
                isPush = false;
            }

            ListNode node = new ListNode(sum);
            ListNode temp = res;
            node.next = temp;
            res = node;
        }

        if (isPush){
            ListNode node = new ListNode(1);
            ListNode temp = res;
            node.next = temp;
            res = node;
        }

        return res;
    }
}
