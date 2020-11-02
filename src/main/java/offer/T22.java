package offer;

public class T22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int[] nums = {1,2,3,4,5};
        int val = 2;
        ListNode head = createList(nums);
        ListNode result = solution22.getKthFromEnd(head,val);
        while(result!=null){
            System.out.print(result.val+"->");
            result=result.next;
        }
    }
    public static ListNode createList(int[] nums){
        ListNode head=new ListNode(0);
        ListNode tail = head;
        for(int  num : nums){
            tail.next = new ListNode(num);
            tail=tail.next;
        }
        return head.next;
    }
}
class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l = head;
        ListNode tail=head;
        while(--k > 0){
            tail=tail.next;
        }
        while(tail.next!=null){
            l=l.next;
            tail=tail.next;
        }
        return l;
    }
}