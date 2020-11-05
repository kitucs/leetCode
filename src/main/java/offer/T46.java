package offer;

//这道题还能将动态规划占用的n空间，简化为3，即o1
public class T46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int re = solution46.translateNum(12258);
        System.out.println(re);
    }
}
class Solution46 {
    public int translateNum(int num) {
        if(num<10) return 1;
        char[] chars = String.valueOf(num).toCharArray();
        int[] f = new int[chars.length];

        f[0]=1;
        if(isok(chars[0],chars[1])){
            f[1] =  2;
        }else{
            f[1] = 1;
        }
        int pre=0,now=0,result=1;
        for (int i = 2; i < chars.length; i++) {
            if(isok(chars[i-1],chars[i])){
                f[i] = f[i-1] +f[i-2];
            }else{
                f[i] = f[i-1];
            }

        }
        return f[chars.length-1];

    }
    public boolean isok(char a,char b){
        if (a=='1'){
            return true;
        }
        if(a=='2' && b>='0' && b<='5' ){
            return true;
        }
        return false;
    }
}