package dp;

public class T44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        boolean re = solution44.isMatch("aa","****");
        System.out.println(re);
    }
}
class Solution44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //初始化
        for (int i = 1; i < p.length()+1; i++) {
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }else
                break;

        }

        //状态转移
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if(p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] & (s.charAt(i-1)==p.charAt(j-1));
                }
            }
        }
        return dp[s.length()][p.length()];

    }
}
