package linkedList;

import offer.TreeNode;

public class T109 {
    public static void main(String[] args) {
        Solution109 solution109 = new Solution109();
        TreeNode node = solution109.sortedListToBST(ListNode.createList(new int[]{-10, -3, 0, 5, 9}));
        TreeNode.printTree(node);
    }
}
class Solution109 {
    // 第一遍，得出长度
    // 第二遍，中序遍历建立节点
    ListNode nowNode=null;
    public TreeNode sortedListToBST(ListNode head) {
        nowNode=head;
        int len = getLen(head);
        return createBST(0,len);

    }
    public int getLen(ListNode  head){
        int re = 0;
        while (head!=null){
            re++;
            head=head.next;
        }
        return re;
    }
    // [1,2)
    public TreeNode createBST(int left,int right){
        System.out.println(left+","+right);
        if(left>=right){
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode now = new TreeNode(-1);

        now.left = createBST(left,mid);
        now.val = nowNode.val;
        nowNode=nowNode.next;
        now.right= createBST(mid+1,right);
        return now;

    }

}