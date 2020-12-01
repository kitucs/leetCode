package linkedList;

import offer.ListNode;

import java.util.List;

public class T82 {
    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        ListNode re =  solution82.deleteDuplicates(ListNode.createList(new int[]{1,1}));
        ListNode.printList(re);
    }
}
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode headFlag = new ListNode(head.val-1);
        headFlag.next = head;
        ListNode pre =headFlag,now = head;
        while (now!=null){
            // 判断当前节点是否需要删除：当前节点的next为空 或 与next不相等
            if(now.next!=null && now.val==now.next.val){
                int tempVal = now.val;
                // 跳过重复值
                while (now!=null && now.val==tempVal){
                    now = now.next;
                }
                // 若是结尾，需要特殊判断
                if(now==null){
                    pre.next=null;
                    break;
                }
            }else{
                // 不删除的节点，拼接起来
                pre.next = now;
                pre = now;
                now = now.next;
            }
        }
        return headFlag.next;
    }
}