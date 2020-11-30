package tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T102 {
    public static void main(String[] args) {
        Solution102 solution102 = new Solution102();
        List<List<Integer>> lists = solution102.levelOrder(TreeNode.creteTree(new int[]{1,2,3,4,5}));
        for(List list:lists){
            System.out.println(list);
        }
    }
}
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        List<TreeNode> preList = new ArrayList<>();
        preList.add(root);

        while (preList.size()>0){
            List<Integer> tempList = new ArrayList<>();
            List<TreeNode> tempTreeNodeList = new ArrayList<>();
            for(TreeNode preListi:preList){
                tempList.add(preListi.val);

                if(preListi.left!=null)
                    tempTreeNodeList.add(preListi.left);
                if(preListi.right!=null)
                    tempTreeNodeList.add(preListi.right);
            }
            preList=tempTreeNodeList;
            result.add(tempList);
        }
        return result;

    }
}