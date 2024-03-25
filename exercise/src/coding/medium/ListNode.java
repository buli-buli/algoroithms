package coding.medium;

public class ListNode {
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
 }