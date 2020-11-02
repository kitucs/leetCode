package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int[] nums = {3,9,20,-1,-1,15,7};
        TreeNode node = TreeNode.creteTree(nums);
        int[] ints = solution32.levelOrder(node);
        for(int intl:ints){
            System.out.println(intl);
        }
    }
}
class Solution32 {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            arrayList.add(node.val);

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;



    }
}
