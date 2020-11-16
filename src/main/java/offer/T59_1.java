package offer;

import java.util.Deque;
import java.util.LinkedList;

public class T59_1 {
    public static void main(String[] args) {
        Solution59_1 solution59_1 = new Solution59_1();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] re =  solution59_1.maxSlidingWindow(nums,k);
        System.out.println(re);
    }

}
class Solution59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        // 1、创建窗口
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            i++;
        }
        return null;
        // 2、移动窗口

    }
}