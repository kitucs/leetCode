package linkedList;

public class T92 {
    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode re = solution92.reverseBetween(ListNode.createList(new int[]{1,2,3,4,5}),1,1);
        ListNode.printList(re);
    }

}
class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headNode = new ListNode(0);
        headNode.next=head;

        ListNode pre=headNode;
        for (int i = 0; i < m-1; i++) {
            pre=pre.next;
        }

        ListNode changeNodes = pre.next;
        ListNode changeNodesTail = changeNodes;
        changeNodes=changeNodes.next;
        for (int i = 1; i < n-m+1; i++) {
            ListNode changeNode = changeNodes;
            changeNodes=changeNodes.next;

            changeNode.next=pre.next;
            pre.next  = changeNode;
        }
        changeNodesTail.next = changeNodes;
        return headNode.next;
    }
}