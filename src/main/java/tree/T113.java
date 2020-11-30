package tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T113 {
    public static void main(String[] args) {
        Solution113 solution113 = new Solution113();
        solution113.dfs(new TreeNode(1),1);

    }
}
class Solution113 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return result;
    }
    public void dfs(TreeNode root, int sum){
        if(root==null){
            return ;
        }
        tempList.add(root.val);
        if(root.left==null && root.right==null){
            if (sum==root.val){
                result.add(new ArrayList<>(tempList));
            }
        }

        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);

        tempList.remove(tempList.size()-1);
    }
}