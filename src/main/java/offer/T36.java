package offer;

public class T36 {
    public static void main(String[] args) {
        Solution36_2 solution362 = new Solution36_2();
        Solution36 solution36 = new Solution36();
        int[] nums = {2,1,3};
        DCNode head= DCNode.createTree(nums);
        DCNode re = solution36.treeToDoublyList(head);
        DCNode now = re;
        for (int i = 0; i < 10; i++) {
            System.out.println(now.val);
            now=now.left;
        }

    }
}


class Solution36 {
    DCNode head,pre;
    public DCNode treeToDoublyList(DCNode root) {
        if(root==null) return null;
        go(root);
        head.left=pre;
        pre.right=head;
        return head;

    }
    public void go(DCNode root){
        if(root==null) return;

        go(root.left);

        if(pre == null){
            //第一次到这
            head = root;
        }else{
            pre.right=root;
            root.left=pre;
        }
        pre= root;


        go(root.right);

    }
}
class Solution36_2 {
    DCNode pre, head;
    public DCNode treeToDoublyList(DCNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(DCNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
