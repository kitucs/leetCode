package tree;

import offer.TreeNode;

public class T111 {
    public static void main(String[] args) {
        Solution111 solution111 = new Solution111();
        solution111.minDepth(new TreeNode(1));
    }
}
class Solution111 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;

        int leftDepth = minDepth(root.left)+1;
        int rightDepth = minDepth(root.right)+1;
        if(root.left==null)
            return rightDepth;
        else if(root.right==null)
            return leftDepth;
        else
            return Math.min(leftDepth,rightDepth);
    }

}