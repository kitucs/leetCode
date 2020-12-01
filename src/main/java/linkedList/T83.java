package linkedList;

public class T83 {
    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode re=  solution83.deleteDuplicates(ListNode.createList(new int[]{1,1,2,3}));
        ListNode.printList(re);
    }
}
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode pre=head,next;
        while (pre!=null){
            next = pre.next;
            while (next!=null && pre.val==next.val){
                next = next.next;
            }
            pre.next = next;
            pre = pre.next;
        }
        return head;


    }
}