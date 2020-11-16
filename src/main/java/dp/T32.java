package dp;

public class T32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int re = solution32.longestValidParentheses("))(())()((((((())(()))((())(((((((()))())((((())())(()())))))))))((()((()(()(()()((()()()(()()()))(()()(()(())())))()())()(((((");
        System.out.println(re);
    }
}
class Solution32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        //以si结尾的字符串，可以构成的最长括号
        //若si==（；意味着为0，故直接跳过
        //dp[0]=0，也跳过，从1开始
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==')'){

                if(s.charAt(i-1)=='('){
                    dp[i] = i>=2?dp[i-2]+2:2;
                }else{
                    //dp[i-1]==')'
                    if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                        // 若找到（与之对应则加2
                        // 还需要加上因为（加入序列连接起来的前面部分
                        dp[i] = dp[i-1] + 2 + (i-dp[i-1]-1 >0 ? dp[i-dp[i-1] - 2] : 0);
                    }
                }
                if(dp[i]>max) max=dp[i];
            }
        }
        return max;

    }
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

}