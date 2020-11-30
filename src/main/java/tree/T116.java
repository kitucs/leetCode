package tree;

public class T116 {
    public static void main(String[] args) {
        Solution116 solution116 = new Solution116();
        solution116.connect(new TreeNodeNext(1));
    }
}
class Solution116 {
    public TreeNodeNext connect(TreeNodeNext root) {
        dfs(root);
        return root;


    }
    public void dfs(TreeNodeNext root){
        if(root==null||root.left==null)
            return;
        root.left.next = root.right;
        if(root.next!=null){
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}