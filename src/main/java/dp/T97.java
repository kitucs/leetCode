package dp;

public class T97 {
    public static void main(String[] args) {
        Solution97 solution97 = new Solution97();
        boolean re = solution97.isInterleave("ab",   "bc", "bcab");
        System.out.println(re);
    }
}
class Solution97 {
    String str1,str2,str3;
    public boolean isInterleave2(String s1, String s2, String s3) {
        str1 =s1 ;
        str2 = s2;
        str3 = s3;
        if(s1.length()+s2.length() != s3.length()) return false;
        return dfs(s1.length()-1,s2.length()-1,s3.length()-1);
    }
    public boolean dfs(int i,int j,int k){
//        if( i<0 && j>=0 && k==0 ) return true;
        if(i<0 && j<0 && k==-1) return true;
        System.out.println(i+","+j+","+k);
//        System.out.println(str1.charAt(i)+","+str2.charAt(j)+","+str3.charAt(k));
        boolean f1 = (i >= 0) && (str1.charAt(i) == str3.charAt(k));
        boolean f2 = (j>=0) && str2.charAt(j)==str3.charAt(k);
//        System.out.println(f1+","+f2);
        if(f1 && f2){
            return dfs(i-1,j,k-1) || dfs(i,j-1,k-1);
        }else if(f1 || f2){
            return f1?dfs(i-1,j,k-1):dfs(i,j-1,k-1);
        }else{
            return false;
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < s1.length()+1; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1) ){
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < s2.length()+1; i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1) ){
                dp[0][i] = dp[0][i-1];
            }
        }
        // 前推
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                System.out.println((i)+","+(j)+","+(i+j));
                boolean f1 =  (s1.charAt(i-1) == s3.charAt(i+j-1));
                boolean f2 =  (s2.charAt(j-1) == s3.charAt(i+j-1));
//                System.out.println(f1+","+f2);
//                if(f1 && f2){
//                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
//                }else if(f1 || f2){
//                    dp[i][j] = f1?dp[i-1][j] : dp[i][j-1];
//                }else{
//                    dp[i][j] = false;
//                }
                dp[i][j] |= f1&dp[i-1][j];
                dp[i][j] |= f2&dp[i][j-1];
            }
        }
        for(boolean[] x:dp){
            for(boolean y:x){
                System.out.print(y+",");
            }
            System.out.println();
        }
        return dp[s1.length()][s2.length()];
    }
}