package dichotomy;

public class T167 {
    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        int[] re = solution167.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(re[0]+","+re[1]);
    }
}
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i,j};
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{-1,-1};

    }
}