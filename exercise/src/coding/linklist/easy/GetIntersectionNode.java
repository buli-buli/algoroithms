package coding.linklist.easy;

/**
 * @ClassNAME GetIntersectionNode
 * @Description 相交链表
 * @Author yu
 * @Date 2023/6/29 10:16
 * @Version 1.0
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获取A链表的最后一个节点
        int lengthA = 1;//记录链表A的节点数
        ListNode flagA = headA;
        while(flagA.next != null){
            flagA = flagA.next;
            lengthA++;
        }
        //获取B链表的最后一个节点
        ListNode flagB = headB;
        int lengthB = 1;//记录链表B的节点数
        while(flagB.next != null){
            flagB = flagB.next;
            lengthB++;
        }

        //如果两个链表的最后一个节点不相同，说明不相交，直接返回null
        if (flagA != flagB){
            return null;
        }

        flagA = headA;
        flagB = headB;

        //让较长的链表先移动abd(lengthA - lengthB步)，然后再同步移动直到找出相交节点
        int distance = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB){
            for (int i = 0; i < distance; i++){
                flagA = flagA.next;
            }
        }else {
            for (int i = 0; i < distance; i++){
                flagB = flagB.next;
            }
        }

        //同步移动两个链表，直到找出相交节点
        while(flagA != flagB){
            flagA = flagA.next;
            flagB = flagB.next;
        }

        return flagA;
    }
}
