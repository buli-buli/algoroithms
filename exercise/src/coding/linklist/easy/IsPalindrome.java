package coding.linklist.easy;

/**
 * @ClassNAME IsPalindrome
 * @Description 回文链表
 * @Author yu
 * @Date 2023/6/29 11:54
 * @Version 1.0
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        IsPalindrome i = new IsPalindrome();
        System.out.println(i.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        //特殊情况处理
        if (head.next == null){
            //链表只有一个元素
            return true;
        }
        if (head == null){
            //链表为空
            return false;
        }
        if (head.next.next == null && head.val == head.next.val){
            //链表包含两个节点且两个节点的值相同
            return true;
        }
        if (head.next.next == null && head.val != head.next.val){
            //链表包含两个节点且两个节点的值不同
            return false;
        }

        //利用快慢指针找到链表中间位置
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //从中间位置反转链表
        ListNode reverse = reverseList(slow);

        //依次比较链表的前半部分和反转后的后半部分的节点值
        while(reverse != null){
            if (reverse.val != head.val){
                return false;
            }

            reverse = reverse.next;
            head = head.next;
        }

        return true;
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
