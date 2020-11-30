package hashTable;

public class T136 {
    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        System.out.println(solution136.singleNumber(new int[]{2,2,1}));

    }
}
class Solution136 {
    public int singleNumber(int[] nums) {
        int re = nums[0];
        for (int i = 1; i < nums.length; i++) {
            re = re ^ nums[i];
        }
        return re;
    }
}