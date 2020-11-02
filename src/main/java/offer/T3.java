package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int x = solution3.findRepeatNumber(nums);
        System.out.println(x);
    }
}
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return 0;
    }
}
//更好的方法：
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
//class Solution {
//    public int findRepeatNumber(int[] nums) {
//        int temp;
//        for(int i=0;i<nums.length;i++){
//            while (nums[i]!=i){
//                if(nums[i]==nums[nums[i]]){
//                    return nums[i];
//                }
//                temp=nums[i];
//                nums[i]=nums[temp];
//                nums[temp]=temp;
//            }
//        }
//        return -1;
//    }
//}
