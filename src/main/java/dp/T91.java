package dp;

public class T91 {
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        int re = solution91.numDecodings("226");
        System.out.println(re);
    }
}
class Solution91 {
    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0)!='0') dp[1]=1;
        for (int i = 1; i < s.length(); i++) {
            int n1 = s.charAt(i)!='0'?dp[i]:0;
            int n2 = isOk(s.charAt(i-1),s.charAt(i))?dp[i-1]:0;
            System.out.println(n1+","+n2);
            dp[i+1] = n1+n2;
        }
        return dp[s.length()];

    }
    public boolean isOk(char c1,char c2){
//        System.out.println(c1+","+c2);
        if(c1=='1' ) return true;
        if(c1=='2' && c2>='0' && c2<='6') return true;
        return false;
    }
}