package dp;

public class T62_2 {
    public static void main(String[] args) {
        Solution62_2 solution62_2 = new Solution62_2();
        int re = solution62_2.uniquePathsWithObstacles(new int[][] {{ 0,1},{0,0}});
        System.out.println(re);
    }
}
class Solution62_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==1){
            dp[0][0] = 0;
        }else{
            dp[0][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0];
            if(obstacleGrid[i][0]==1)
                dp[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1];
            if(obstacleGrid[0][i]==1)
                dp[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j] =  dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];

    }
}