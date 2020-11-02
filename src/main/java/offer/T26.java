package offer;

public class T26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums1 = {3,4,5,1,2};
        int[] nums2 = {4,1};
        TreeNode treeNode1 = TreeNode.creteTree(nums1);
        TreeNode treeNode2 = TreeNode.creteTree(nums2);
        boolean re = solution26.isSubStructure(treeNode1,treeNode2);
        System.out.println(re);
    }
}

class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null) return true;
        return findVal(A,B);
    }
    public boolean findVal(TreeNode A,TreeNode B){
        if(A==null) return false;
//        System.out.println(A.val+","+B.val);
        if(A.val==B.val && compareTo(A,B)){
            return true;
        }
        return findVal(A.left,B)|| findVal(A.right,B);
    }
    public boolean compareTo(TreeNode A,TreeNode B){
        if(B==null)
            return true;
        if(A==null && B!=null)
            return false;
//        if(A!=null && B==null)
//            return false;
//        System.out.println(A.val+",,,"+B.val);

        if(A.val != B.val)
            return false;
        else
            return compareTo(A.left,B.left) && compareTo(A.right,B.right);
    }
}
