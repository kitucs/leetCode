package T1_10;

import java.util.List;

class ListNode {
     int val;
     ListNode next=null;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder line = new StringBuilder();
        while(head!=null){
            line.append(head.val).append(",");
            head = head.next;
        }
        System.out.println(line);
        return null;
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cout = 0;
        int a=0;
        int b=0;
        int c = 0;
        int now = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1!=null || l2!=null || cout>0){
            if(l1!=null){
                a=l1.val;
                l1=l1.next;
            }else{
                a=0;
            }

            if(l2!=null){
                b=l2.val;
                l2=l2.next;
            }else{
                b=0;
            }
            c = a+b+cout;
            cout = c/10;
            now = c%10;
            tail.next = new ListNode(now);
            tail = tail.next;
        }
        return head.next;
    }
}
public class T2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums1 = {5};
        int[] nums2 = {5};
        ListNode list1 = createList(nums1);
        ListNode list2 = createList(nums2);
        ListNode result = solution2.addTwoNumbers(list1,list2);
        result.toString();

    }
    /**
     * 根据数组创建链表
     */
    public static ListNode createList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        for(int i=1;i<nums.length;i++){
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return head;
    }
}