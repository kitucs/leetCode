package offer;

public class T18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int[] nums = {4,5,1,9};
        int val = 4;
        ListNode head = createList(nums);
        ListNode result = solution18.deleteNode(head,val);
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
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

/**
 * 删除第i个节点，不一定需要i
 */
class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode lhead = new ListNode(0);
        lhead.next = head;
        ListNode l=lhead;
        ListNode r =head;
        while(r!=null){
            if(r.val==val){
                l.next = r.next;
                r.next = null;
                return lhead.next;
            }
            l=l.next;
            r=r.next;

        }
        return lhead.next;


    }
}
