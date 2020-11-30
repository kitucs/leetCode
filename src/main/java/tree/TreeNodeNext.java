package tree;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeNext {
    public int val;
    public TreeNodeNext left;
    public TreeNodeNext right;
    public  TreeNodeNext next;
    TreeNodeNext(int val){
        this.val=val;
    }
    public TreeNodeNext(int _val, TreeNodeNext _left, TreeNodeNext _right, TreeNodeNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }


    public static TreeNodeNext creteTree(int[] nums){
        if(nums.length==0) return null;
        TreeNodeNext root = new TreeNodeNext(nums[0]);
        Queue<TreeNodeNext> queue = new LinkedList<>();
        int i=0;
        queue.offer(root);
        while(!queue.isEmpty() && i<nums.length){
            TreeNodeNext treeNode = queue.poll();
            i++;
            if(i<nums.length){
                if(nums[i]==-2 ){
                    treeNode.left = null;
                }
                else{
                    treeNode.left = new TreeNodeNext(nums[i]);
                    queue.offer(treeNode.left);
                }
            }
            i++;
            if(i<nums.length){
                if(nums[i]==-2){
                    treeNode.right = null;
                }
                else{
                    treeNode.right = new TreeNodeNext(nums[i]);
                    queue.offer(treeNode.right);
                }

            }
        }
        return root;
    }
}
