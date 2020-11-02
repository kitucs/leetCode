package offer;

import java.util.ArrayList;
import java.util.List;

public class T34 {
    public static void main(String[] args) {
        Solution34 solution34 =new Solution34();
        int[] nums = {1,-2,-3,1,3,-2,-1000,-1};
        TreeNode treeNode = TreeNode.creteTree(nums);
        List<List<Integer>> list = solution34.pathSum(treeNode, -1);
        for(List<Integer> list1 : list){
            System.out.println("list:");
            for(int x : list1){
                System.out.print(x + ",");
            }
            System.out.println("");
        }
    }
}
class Solution34 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return result;
        tempList.add(root.val);
        findPath(root,sum-root.val);
        return result;
    }
    public void findPath(TreeNode root,int sum){
        if(sum==0 && root.left==null && root.right==null){
//            System.out.println(tempList);
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(root.left!=null){
            tempList.add(root.left.val);
            findPath(root.left,sum-root.left.val);
            tempList.remove(tempList.size()-1);
        }
        if(root.right!=null){
            tempList.add(root.right.val);
            findPath(root.right,sum-root.right.val);
            tempList.remove(tempList.size()-1);
        }
    }
}