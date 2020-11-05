package offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T52 {
    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        int [] nums1={4,1,8,4,5};
        int [] nums2={5,0,1,8,4,5};
        ListNode h1 = ListNode.createList(nums1);
        ListNode h2 = ListNode.createList(nums2);
        ListNode re = solution52.getIntersectionNode(h1,h2);
        ListNode.printList(re);
    }
}
 class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(headA!=null){
            stack1.push(headA);
            headA=headA.next;
        }
        while(headB!=null){
            stack2.push(headB);
            headB=headB.next;
        }
        System.out.println(stack2.size());
        ListNode start = null;
        while((!stack1.isEmpty())&&(!stack2.isEmpty())){
            ListNode n1 = stack1.pop();
            ListNode n2 = stack2.pop();
            System.out.println(n1.val+","+n2.val);
            if(n1!=n2){
                break;
            }
            start = n1;
        }
        return start;
    }
     public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //快慢指针
         // a,b同时
         //a到达null后 a->headB
         // b达到null后,b->headA
         return null;
     }
}
