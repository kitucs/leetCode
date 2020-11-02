package offer;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static TreeNode creteTree(int[] nums){
        if(nums.length==0) return null;
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        int i=0;
        queue.offer(root);
        while(!queue.isEmpty() && i<nums.length){
            TreeNode treeNode = queue.poll();
            i++;
            if(i<nums.length){
                if(nums[i]==-1000){
                    treeNode.left = null;
                }
                else{
                    treeNode.left = new TreeNode(nums[i]);
                    queue.offer(treeNode.left);
                }
            }
            i++;
            if(i<nums.length){
                if(nums[i]==-1){
                    treeNode.right = null;
                }
                else{
                    treeNode.right = new TreeNode(nums[i]);
                    queue.offer(treeNode.right);
                }

            }
        }
        return root;
    }
    public static void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
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
