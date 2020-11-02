package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T37 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        int[] nums = {1,2,3,-1,-1,4,5};
        TreeNode re = TreeNode.creteTree(nums);
        System.out.println(codec.serialize(re));


    }

}


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //层次遍历
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder("[");
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(head!=null){
                queue.add(head.left);
                queue.add(head.right);
                stringBuilder.append(head.val).append(",");
            }else{
                stringBuilder.append("null,");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);//删除多余的,
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data){
        String[] nums = data.substring(1,data.length()-1).split(",");
        if(nums[0].length()==0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int i=0;
        queue.offer(root);
        while(!queue.isEmpty() && i<nums.length){
            TreeNode treeNode = queue.poll();
            i++;
            if(i<nums.length){
                if(nums[i].equals("null")){
                    treeNode.left = null;
                }
                else{
                    treeNode.left = new TreeNode(Integer.parseInt(nums[i]));
                    queue.offer(treeNode.left);
                }
            }
            i++;
            if(i<nums.length){
                if(nums[i].equals("null")){
                    treeNode.right = null;
                }
                else{
                    treeNode.right = new TreeNode(Integer.parseInt(nums[i]));
                    queue.offer(treeNode.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));