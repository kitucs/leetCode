package offer;

public class T4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] matrix = {{1,1}};
        int target = 2;
        boolean has = solution4.findNumberIn2DArray(matrix,target);

        System.out.println(has);
    }
}
class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int n=matrix[0].length,m=matrix.length;
        int i=0,j=n-1;
        System.out.println(m+","+n);
        while(i<m && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }


        return false;

    }
}