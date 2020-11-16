package offer;

import java.util.HashSet;
import java.util.Set;

public class T61 {
    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        boolean re = solution61.isStraight(new int[] {1,2,3,4,5});
        System.out.println(re);

    }
}
class Solution61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min=14,max=-1;
        for (int i = 0; i < 5; i++) {
            if(nums[i]==0) continue;
            if(set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
            max=Math.max(nums[i],max);
            min = Math.min(nums[i], min);
        }
        return max - min < 5;
    }
}
