package offer;

public class T68 {
    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        TreeNode treeNode = TreeNode.creteTree(new int[] {6,2,8,0,4,7,9,-1000,-1000,3,5});
        TreeNode common =  solution68.lowestCommonAncestor(treeNode,new TreeNode(3),new TreeNode(4));
        System.out.println(common.val);
    }
}
class Solution68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                root = root.left;
            }else if(p.val>root.val && q.val>root.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
    }

}