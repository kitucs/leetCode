package tree;

import offer.TreeNode;

public class T98 {
    public static void main(String[] args) {
        Solution98 solution98 = new Solution98();
        TreeNode node = new TreeNode(-2147483648);
//        node.right=new TreeNode(-2147483648);
        boolean re = solution98.isValidBST(node);
        System.out.println(re);
    }
}
class Solution98 {
    boolean firstMin=true,firstMax=true;
    public boolean isValidBST(TreeNode root) {
        return isOk(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isOk(TreeNode root,int treeMin,int treeMax){
        if(root==null){
            return true;
        }
        if(root.val<=treeMin||root.val>=treeMax){
            if(root.val==Integer.MAX_VALUE && firstMax && treeMax==Integer.MAX_VALUE){
                firstMax=false;
            }
            else if(root.val==Integer.MIN_VALUE && firstMin && treeMin==Integer.MIN_VALUE) {
                firstMin = false;
            }else
                return false;
        }

        return isOk(root.left,treeMin,root.val) && isOk(root.right,root.val,treeMax);
    }
}