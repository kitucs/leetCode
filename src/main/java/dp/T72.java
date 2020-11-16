package dp;

public class T72 {
    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        int re = solution72.minDistance("intention","execution");
        System.out.println(re);

    }
}

/**
 * 对于 word1 --> word2，设 dp[i][j] : word1[i] --> word2[j]，前word1的前i-1目前和word2的前j-1匹配，此时：
 * 分析题目，对于状态转移只有以下几种情况：
 * 一、(当word1[i] != word2[j])
 * （1）删除 word1[i]；则此时状态转移为 dp[i][j]-->dp[i+1][j] ；（删除只是名义删除）新状态表示：利用word1的前i个字符，经过之前的操作已经与word2的前j-1个字符匹配
 * （2）插入 word1[i]；状态转移为：dp[i][j]-->dp[i+1][j]
 * （3）替换 word1[i]；状态转移为：dp[i][j]-->dp[i+1][j+1]
 * 二、(当word1[i] == word2[j])
 * dp[i][j]-->dp[i+1][j+1]
 *
 * 当word1[i] != word2[j]时
 * 从以上分析可以得出，dp[i][j]的所有来源： dp[i-1][j],dp[i-1][j-1],dp[i][j-1] ； （反过来看转移）
 * 每次操作都会+1，因此只要将所有来源的最小值+1，就是当前的值
 * 当word1[i] == word2[j]时则直接转移
 */
class Solution72 {
    public int minDistance(String word1, String word2) {
        if(word1==""|| word2.equals("")){
            return Math.max(word1.length(),word2.length());
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        //初始化：空串变成一个字符串，最短距离即长度
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        //自底向上
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
