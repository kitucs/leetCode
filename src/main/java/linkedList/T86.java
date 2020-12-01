package linkedList;

public class T86 {
    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
        ListNode re = solution86.partition(ListNode.createList(new int[]{1,4,3,2,5,2}),3);
        ListNode.printList(re);
    }
}
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead=new ListNode(0),leftTail=leftHead;
        ListNode rightHead=new ListNode(0),rightTail=rightHead;
        while (head!=null){
            if(head.val<x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next=rightHead.next;
        rightTail.next=null;
        return leftHead.next;



    }
}