package offer;

public class T46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int re = solution46.translateNum(12258);
        System.out.println(re);
    }
}
class Solution46 {
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] f = new int[chars.length];
        f[0]=0;
        int pre=0,now=0,result=1;
        for (int i = 1; i < chars.length; i++) {
            if(isok(chars[i-1],chars[i])){

            }

        }

    }
    public boolean isok(char a,char b){
        if (a<'2'){
            return true;
        }
    }
}