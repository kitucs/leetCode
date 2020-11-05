package offer;

public class T58_2 {
    public static void main(String[] args) {
        Solution58_2 solution58_2 = new Solution58_2();
        String s = "abcdefg";
        int t = 2;
        String re = solution58_2.reverseLeftWords(s,t);
        System.out.println(re);
    }
}
class Solution58_2 {
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        String pre = s.substring(n,s.length());
        String tail = s.substring(0,n);
        return pre+tail;

    }
}