package tree;

public class T96 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int re = solution96.numTrees(4);
        System.out.println(re);
    }
}
class Solution96 {
    public int numTrees(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];

    }
}