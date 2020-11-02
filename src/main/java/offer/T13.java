package offer;

public class T13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int m = 3, n = 1, k = 0;
        solution13.movingCount(m,n,k);
    }

}

class Solution13 {
    int count = 0;
    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        move(0,0,k,grid);
        return count;

    }
    public void move(int i,int j,int k,int[][] grid){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==0 && isOk(i,j,k)){
//            System.out.println(i+","+j+","+count);
            grid[i][j] = 1;
            count ++;
            move(i+1,j,k,grid);
            move(i-1,j,k,grid);
            move(i,j+1,k,grid);
            move(i,j-1,k,grid);
        }

    }
    public boolean isOk(int i,int j,int k){
        int sum=0;
        while(i>0){
            sum += i%10;
            i /= 10;
        }
        while(j>0){
            sum += j%10;
            j /= 10;
        }
        return sum <= k;
    }
}