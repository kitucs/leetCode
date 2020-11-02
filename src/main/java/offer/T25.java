package offer;

public class T25 {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        int[] nums1 = {2,4,6};
        int[] nums2 = {1,3,5,7};
        ListNode head1 = createList(nums1);
        ListNode head2 = createList(nums2);
        ListNode result = solution25.mergeTwoLists(head1,head2);
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
class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode r1=l1,r2=l2;
        if(l1.val>l2.val){
            r1=l2;
            r2=l1;
        }
        ListNode r1Min=r1,r1Max;
        while(r1Min.next!=null){
            System.out.println(r1Min.val);
            r1Max=r1Min.next;
            //找到介于r1Min-r1Max之间的链表，然后接上去
            //r1Min - r2 -....- r2tailPre - r1Max
            //        r2-.... - r2tailPre -X- r2tail
            ListNode r2tailPre = null,r2tail=r2;//r2前驱节点
            while(r2tail!=null && r2tail.val<r1Max.val){
                r2tailPre=r2tail;
                r2tail=r2tail.next;
            }
            //找到了，则接上去
            if(r2tailPre!=null){
                r1Min.next=r2;
                r2tailPre.next=r1Max;
                r2=r2tail;
            }
            r1Min = r1Max;
        }
        if(r2!=null){
            r1Min.next=r2;
        }
        return r1;
    }
}