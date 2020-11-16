package dp;

public class T10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        boolean re = solution10.isMatch("aa","a");
        System.out.println(re);

    }
}
class Solution10 {
    public boolean isMatch(String s, String p) {
        //dp[i][j] p的前j个字符组成的正则表达式能否匹配s前i个字符
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        // 初始化dp矩阵
        for (int i = 1; i < p.length()+1; i++) {
            if(pChars[i-1]=='*')
                dp[0][i] = dp[0][i-2];
        }
        // 计算
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if((pChars[j-1]==sChars[i-1])||pChars[j-1]=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pChars[j-1]=='*'){
                    if( (sChars[i-1]==pChars[j-2]) || pChars[j-2]=='.'){
                        dp[i][j] = dp[i][j-2] | dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
                // 验证
                System.out.println(p.substring(0,j)+"========"+s.substring(0,i)+" ========"+dp[i][j]);
            }

        }
        //返回
        return dp[s.length()][p.length()];

    }
}
