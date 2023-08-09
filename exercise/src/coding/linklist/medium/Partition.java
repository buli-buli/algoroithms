package coding.linklist.medium;


/**
 * @ClassNAME Partition
 * @Description 分隔链表
 * @Author yu
 * @Date 2023/8/9 16:16
 * @Version 1.0
 */
public class Partition {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        Partition p = new Partition();
        ListNode.printNode(p.partition(head, 2));
    }

    public ListNode partition(ListNode head, int x) {
        //新建一个零节点，将它的next指针指向head，兼容链表开头就是大于x的节点的情况
        ListNode ans = new ListNode(0);
        ans.next = head;

        //记录上一个移动val小于x的节点的指针，遍历时每发现一个需要移动的节点就将flag的next指向这个节点，然后向前移动一位
        //总之这个变量就是为了记录上一次操作的节点位置
        ListNode flag = ans;

        //找到第一个val大于x的节点的前一个节点
        while(flag.next != null && flag.next.val < x){
            flag = flag.next;
        }

        //链表遍历起点
        ListNode curr = flag.next;
        //链表遍历起点的前一个结点，初始值为0节点
        ListNode prev = flag;

        //开始分隔链表
        while (curr != null){
            if (curr.val >= x){
                //节点值大于等于x，无需移动，直接指向下一个节点
                prev = curr;
                curr = curr.next;
            }else {
                //从链表中抽出需要移动位置的节点，具体操作是直接将prev的next指针指向当前节点的next指针
                prev.next = curr.next;

                //把上一次操作的节点的next指针指向当前节点
                curr.next = flag.next;
                flag.next = curr;

                //设置当前节点为上一次操作的节点
                flag = curr;

                //将curr节点前进一位，把curr设置为移动节点之前被移动节点的next指针指向的节点
                curr = prev.next;
            }
        }

        return ans.next;
    }
}
