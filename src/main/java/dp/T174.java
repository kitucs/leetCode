package dp;

public class T174 {
    public static void main(String[] args) {
        Solution174 solution174 = new Solution174();
        int[][] nums = {{0,0,-50,2},{1,-50,100,1},{1,-1,-4,0}};
        int re =solution174.calculateMinimumHP(nums);
        System.out.println(re);
    }
}

/**
 * 注意不是求有最大累计值的路径
 * 要求的是玩家在 0,0 位置的血量，因此不能从0，0开始到m,n
 *  dp[i][j] 代表从 i j到终点最差情况下，会掉到多少血
 */
class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int m =dungeon.length-1;
        int n = dungeon[0].length-1;
        dp[m][n] = dungeon[m][n]<0?(-dungeon[m][n]):0;
        for (int i = m-1; i >= 0; i--) {
            if(dungeon[i][n]<0){
                dp[i][n] = dp[i+1][n] - dungeon[i][n];
            }else{
                dp[i][n] = Math.max(0,dp[i+1][n] -dungeon[i][n]);
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if(dungeon[m][i]<0){
                dp[m][i] = dp[m][i+1] -dungeon[m][i];
            }else{
                dp[m][i] = Math.max(0,dp[m][i+1] -dungeon[m][i]);
            }
        }

        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                if(dungeon[i][j]<=0){
                    dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j]) - dungeon[i][j];
                }else{
                    dp[i][j] = Math.max(0, Math.min(dp[i][j+1],dp[i+1][j]) -dungeon[i][j]);
                }

            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        return  dp[0][0]+1;

    }
}