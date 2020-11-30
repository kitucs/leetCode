package tree;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T117 {
    public static void main(String[] args) {
        Solution117 solution117 = new Solution117();
        //[2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7]
        solution117.connect(TreeNodeNext.creteTree(new int[]{2,1,3,0,7,9,1,2,-1,1,0,-1,-1,8,8,-1,-1,-1,-1,7}));
    }
}
class Solution117 {
    public TreeNodeNext connect(TreeNodeNext root) {


        bfs(root);
        return root;
    }
    //存在问题： 遍历到7时，需要的9.next=1还没有执行，只能bfs解决
    public void dfs(TreeNodeNext root){
        if(root==null||(root.left==null&&root.right==null))
            return;

        if(root.val==7){
            System.out.println(root.val);
        }
        if(root.left==null){
            root.right.next= findNext(root);

        }else if(root.right==null){
            root.left.next = findNext(root);
        }else{
            root.left.next = root.right;
            root.right.next = findNext(root);
        }

        dfs(root.left);
        dfs(root.right);
    }
    public void bfs(TreeNodeNext root){
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty() ){
            root = queue.poll();
            if(root.left==null&&root.right==null){
                continue;
            }
            if(root.left!=null){
                queue.offer(root.left);
            }
            if(root.right!=null){
                queue.offer(root.right);
            }


            if(root.left==null){
                root.right.next= findNext(root);

            }else if(root.right==null){
                root.left.next = findNext(root);
            }else{
                root.left.next = root.right;
                root.right.next = findNext(root);
            }
        }
    }
    public TreeNodeNext findNext(TreeNodeNext root){
        root = root.next;
        while (root!=null){
            if(root.left!=null)
                return root.left;
            if(root.right!=null)
                return root.right;
            root = root.next;
        }
        return null;

    }
}