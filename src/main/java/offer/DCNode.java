package offer;

import java.util.LinkedList;
import java.util.Queue;

public class DCNode {

    public int val;
    public DCNode left;
    public DCNode right;

    public DCNode() {}

    public DCNode(int _val) {
        val = _val;
    }

    public DCNode(int _val,DCNode _left,DCNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    public static DCNode createTree(int[] nums){
        if(nums.length==0) return null;
        DCNode root = new DCNode(nums[0]);
        Queue<DCNode> queue = new LinkedList<>();
        int i=0;
        queue.offer(root);
        while(!queue.isEmpty() && i<nums.length){
            DCNode treeNode = queue.poll();
            i++;
            if(i<nums.length){
                if(nums[i]==-1000){
                    treeNode.left = null;
                }
                else{
                    treeNode.left = new DCNode(nums[i]);
                    queue.offer(treeNode.left);
                }
            }
            i++;
            if(i<nums.length){
                if(nums[i]==-1){
                    treeNode.right = null;
                }
                else{
                    treeNode.right = new DCNode(nums[i]);
                    queue.offer(treeNode.right);
                }

            }
        }
        return root;
    }
    public static void printTree(DCNode root){
        Queue<DCNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            DCNode treeNode = queue.poll();
            System.out.println(treeNode.val+",");
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
        }
    }
}