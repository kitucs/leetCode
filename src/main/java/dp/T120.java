package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T120 {
    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Collections.singletonList(2));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3,4));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(4,1,8,3));
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        System.out.println(solution120.minimumTotal(list));
    }
}
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i-1][0]+ list.get(0);
            for (int j = 1; j < list.size()-1; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+list.get(j);
            }
            dp[i][list.size()-1] = dp[i-1][list.size()-2]+ list.get(list.size()-1);
        }

        int min = dp[dp.length-1][0];

        for (int i = 1; i < dp.length ; i++) {
            min = Math.min(min,dp[dp.length-1][i]);
        }
        return min;

    }
}