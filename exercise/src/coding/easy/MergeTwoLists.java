package coding.easy;

import java.util.LinkedList;

/**
 * @ClassNAME MergeTwoLists
 * @Description 合并两个有序链表
 * @Author yu
 * @Date 2023/6/25 16:06
 * @Version 1.0
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode list3 = new ListNode(0);
        ListNode node = list3;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            }else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null){
            node.next = list1;
        }else {
            node.next = list2;
        }

        return list3.next;
    }
}




