package offer;

public class T28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int[] nums = {1,2,2,3,4,4,3};
        TreeNode node = TreeNode.creteTree(nums);
        boolean re = solution28.isSymmetric(node);
        System.out.println(re);

    }
}
class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if((root==null)) return true;
        return compareTo(root.left,root.right);
    }
    public boolean compareTo(TreeNode r1,TreeNode r2){
        if((r1==null&&r2!=null)||(r1!=null&&r2==null))
            return false;
        if(r1==null&&r2==null)
            return true;
        if(r1.val!=r2.val)
            return false;
        return compareTo(r1.left,r2.right)&&compareTo(r1.right,r2.left);

    }
}