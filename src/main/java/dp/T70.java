package dp;

public class T70 {
    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        solution70.climbStairs(5);
    }
}
class Solution70 {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];

    }
}