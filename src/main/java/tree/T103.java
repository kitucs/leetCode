package tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T103 {
    public static void main(String[] args) {
        Solution103 solution103 = new Solution103();
        solution103.zigzagLevelOrder(new TreeNode(1));
    }
}
class Solution103 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root==null) return new ArrayList<>();
            List<List<Integer>> result=new ArrayList<>();
            List<TreeNode> preList = new ArrayList<>();
            preList.add(root);
            int flag=-1;
            while (preList.size()>0){
                List<Integer> tempList = new ArrayList<>();
                List<TreeNode> tempTreeNodeList = new ArrayList<>();

                for (int i = preList.size()-1; i >=0 ; i--) {
                    TreeNode preListi = preList.get(i);
                    tempList.add(preListi.val);
                    if(flag==1){
                        if(preListi.right!=null)
                            tempTreeNodeList.add(preListi.right);
                        if(preListi.left!=null)
                            tempTreeNodeList.add(preListi.left);
                    }else{
                        if(preListi.left!=null)
                            tempTreeNodeList.add(preListi.left);
                        if(preListi.right!=null)
                            tempTreeNodeList.add(preListi.right);
                    }
                }
                flag=flag*-1;


                preList=tempTreeNodeList;
                result.add(tempList);
            }
            return result;

    }
}