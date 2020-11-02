package offer;

public class T24 {
    public static void main(String[] args) {
        Solution24 solution24= new Solution24();
        int[] nums = {1};
        ListNode head = createList(nums);
        ListNode result = solution24.reverseList(head);
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
class Solution24 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode lastNode=null,nextNode=head;
        while(true){
            if(nextNode.next==null){
                nextNode.next=lastNode;
                return nextNode;
            }
            ListNode l = nextNode;
            ListNode r = nextNode.next;
            nextNode=r.next;
            l.next=lastNode;
            r.next=l;
            lastNode=r;
            if(nextNode==null)
                return r;
        }
    }
}
