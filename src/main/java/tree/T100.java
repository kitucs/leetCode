package tree;

import offer.TreeNode;

public class T100 {
    public static void main(String[] args) {
        Solution100 solution100 = new Solution100();
        solution100.isSameTree(new TreeNode(1),new TreeNode(2) );
    }
}
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p==null)||(q==null))
            return false;
        if( p.val!=q.val )
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}