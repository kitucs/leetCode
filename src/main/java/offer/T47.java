package offer;

//可以将空间复杂度降低
public class T47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int re = solution47.maxValue(grid);
        System.out.println(re);
    }
    public static void printIntArray2(int[][] grid){
        //print
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }
    }
}
class Solution47 {
    public int maxValue(int[][] grid) {
        int[][] maxGrid = new int[grid.length][grid[0].length];
        maxGrid[0][0] = grid[0][0];
        // init
        for (int i = 1; i < grid.length; i++) {
            maxGrid[i][0] = grid[i][0]+maxGrid[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            maxGrid[0][i] = grid[0][i]+maxGrid[0][i-1];
        }
//        T47.printIntArray2(maxGrid);

        //move
        int max = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                max = (maxGrid[i-1][j]>maxGrid[i][j-1]) ? maxGrid[i-1][j] : maxGrid[i][j-1];
                maxGrid[i][j] = grid[i][j] + max;

            }
        }
        return maxGrid[grid.length-1][grid[0].length-1];
    }
}