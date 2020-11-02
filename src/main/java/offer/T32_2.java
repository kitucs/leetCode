package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T32_2 {
    public static void main(String[] args) {
        Solution32_2 solution33 = new Solution32_2();
        int[] nums = {1,2,-1,3,-1,4,-1,5};
        TreeNode node = TreeNode.creteTree(nums);
        List<List<Integer>> lists = solution33.levelOrder(node);
        System.out.println("result");
        for(List<Integer> listInternet:lists){
            System.out.println("new line");
            for(Integer val:listInternet){
                System.out.println(val);
            }
        }

    }
}
class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> tempQueue = new LinkedList<>();
        List<Integer> listVal = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);
        listVal.add(root.val);
        result.add(new ArrayList<Integer>(listVal));
        while(!queue.isEmpty()){
            Queue<TreeNode> tempQueue = new LinkedList<>();
            listVal.clear();
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null){
                    tempQueue.add(treeNode.left);
                    listVal.add(treeNode.left.val);
                }
                if(treeNode.right!=null){
                    tempQueue.add(treeNode.right);
                    listVal.add(treeNode.right.val);
                }
            }
            //将listVal加入result
            System.out.println(listVal);
            if(listVal.size()>0) {
                result.add(new ArrayList<Integer>(listVal));
            }

            queue = tempQueue;

        }
        return result;


    }
}
class Solution32_2S {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

