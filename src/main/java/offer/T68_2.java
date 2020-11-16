package offer;

public class T68_2 {
    public static void main(String[] args) {
        Solution68_2 solution68_2 = new Solution68_2();
        TreeNode treeNode = TreeNode.creteTree(new int[] {6,2,8,0,4,7,9,-1000,-1000,3,5});
        solution68_2.lowestCommonAncestor(treeNode,new TreeNode(3),new TreeNode(4));
    }
}
class Solution68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;

        TreeNode leftRe = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRe = lowestCommonAncestor(root.right,p,q);

//        if(leftRe!=null && rightRe!=null)
//            return root;
//        if((leftRe==null && rightRe!=null)|| (leftRe!=null && rightRe==null))
//            return leftRe==null?rightRe:leftRe;
//        else
//            return null;

        if(leftRe==null && rightRe==null){
            return null;
        }
        if(leftRe==null) return rightRe;
        if(rightRe==null) return leftRe;
        return root;

    }
}
