package tree;

import offer.TreeNode;

public class T112 {
    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
        solution112.hasPathSum(new TreeNode(1),22);
    }
}
class Solution112  {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return sum==root.val;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);



    }


}