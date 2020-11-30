package dichotomy;

public class T74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean re = solution74.searchMatrix(nums, 21);
        System.out.println(re);
    }
}
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int top=0,down=matrix.length-1,row=-1;
        // 找到行
        while(top<=down){
            row = down + (top-down)/2;
            if(matrix[row][0]>target){
                down = row - 1;
            }else if(matrix[row][ matrix[0].length-1 ]<target){
                top = row + 1;
            }else{
                break;
            }
        }

        int left=0,right=matrix[0].length-1,mid=-1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(matrix[row][mid]>target){
                right = mid - 1;
            }else if(matrix[row][mid]<target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;


    }
}