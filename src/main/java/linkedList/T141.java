package linkedList;


public class T141 {
    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
        ListNode list = ListNode.createList(new int[]{3, 2, 0, -4});
        solution141.hasCycle(list);
    }
}
 class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head.next;
        while (true){
            if(fast==null||fast.next==null){
                return false;
            }
            if(fast==slow){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

    }
}