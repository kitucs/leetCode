package offer;

public class T5 {
    public static void main(String[] args) {
        Solution5 solution5=new Solution5();
        String s="";
        String re =solution5.replaceSpace(s);
        System.out.println(re);
    }
}
class Solution5 {
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}