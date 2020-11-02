package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T32_3 {
    public static void main(String[] args) {
        Solution32_3 solution34 = new Solution32_3();
        int[] nums = {1,2,3,4,-1,-1,5};
        TreeNode node = TreeNode.creteTree(nums);
        List<List<Integer>> lists = solution34.levelOrder(node);
        System.out.println("result");
        for(List<Integer> listInternet:lists){
            System.out.println("new line");
            for(Integer val:listInternet){
                System.out.println(val);
            }
        }
    }

}
class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null) return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            int flag=-1;//1 左到右 -1 右到左
            queue.add(root);
            while (!queue.isEmpty()){
                LinkedList<Integer> list = new LinkedList<>();
                LinkedList<TreeNode> TempQueue = new LinkedList<>();
                System.out.println(flag);
                while (!queue.isEmpty()){
                    TreeNode node;
                    node = queue.poll();
                    //入list顺序
                    if(flag==1)
                        list.addFirst(node.val);
                    else
                        list.addLast(node.val);
                    //入队
                    if(node.left!=null){
                        TempQueue.add(node.left);
                    }
                    if(node.right!=null){
                        TempQueue.add(node.right);
                    }
                }
                queue=TempQueue;

                result.add(list);
                flag = flag*-1;
            }
            return result;
        }
    }
class Solution32_3_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int flag=-1;//1 左到右 -1 右到左
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
//            System.out.println(queue.size());
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                System.out.println("size:"+queue.size());
                TreeNode node =queue.poll();
                //入list顺序
                if(flag==1)
                    list.addFirst(node.val);
                else
                    list.addLast(node.val);
                //入队
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

            result.add(list);
            flag = flag*-1;
        }
        return result;
    }
}