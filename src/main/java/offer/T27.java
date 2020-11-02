package offer;

public class T27 {
    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int [] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.creteTree(nums);
        TreeNode node = solution27.mirrorTree(root);
        TreeNode.printTree(node);
    }
}
class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode l = mirrorTree(root.left);
        TreeNode r = mirrorTree(root.right);
        root.left = r;
        root.right=l;
        System.out.println("root"+root.val);
        return root;
    }
}