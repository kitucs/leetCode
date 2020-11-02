package offer;

import java.util.Stack;

public class T31 {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] nums1={1,2,3,4,5};
        int[] nums2={4,3,5,1,2};
        boolean re = solution31.validateStackSequences(nums1,nums2);
        System.out.println(re);
    }
}
class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        while (true) {
            //栈非空时，判断栈顶元素和出栈第一个元素是否相等
            while (!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
            //入栈
            if (i < pushed.length){
                stack.push(pushed[i++]);
            }else{
                //此时根据
                return stack.isEmpty();
            }
        }

    }
}