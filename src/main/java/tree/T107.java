package tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T107 {
    public static void main(String[] args) {
        Solution107 solution107 =new Solution107();
        solution107.levelOrderBottom(new TreeNode(1));
    }
}
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        LinkedList<List<Integer>> result=new LinkedList<>();

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
            result.addLast(tempList);
        }
        return result;
    }
}