package coding.linklist.medium;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printNode(ListNode res){
        while(res != null){
            if (res.next != null){
                System.out.print(res.val + "->");
            }else {
                System.out.print(res.val);
            }

            res = res.next;
        }
        System.out.println();
    }

    //输入个数作为限制，用于打印环形链表
    public static void printNode(ListNode res, int count){
        int i = 0;
        while(res != null && i < count){
            if (res.next != null && i < count - 1){
                System.out.print(res.val + "->");
            }else {
                System.out.print(res.val);
            }

            res = res.next;
            i++;
        }
        System.out.println();
    }
}