package offer;

public class T20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String s =". 1";
        boolean re =solution20.isNumber(s);
        System.out.println(re);

    }
}
class Solution20 {
    public boolean isNumber(String s) {
        char[] chars = s.replace(" ","").toCharArray();
        if(chars.length==0) return false;
        if(chars[0]=='e'||chars[0]=='E') return false;
        int re = getNum(chars,0);
        //num
        if(re==chars.length)
            return true;

        if(chars[re]=='e'||chars[re]=='E'){
            re =getNum(chars,re+1);
        }else if(chars[re]=='.'){
            if(re==chars.length-1 && re>0)
                return true;
            re =getUnNum(chars,re+1);
        }else{
            return false;
        }

        if(re==chars.length)
            return true;
        else
            return false;


    }
    public int getNum(char[] chars,int i){
        if(i>=chars.length) return 0;
        if(chars[i]=='+' || chars[i]=='-'){
            i++;
        }
        while(i<chars.length && chars[i]>='0' && chars[i]<='9' ){
            i++;
        }
        return i;
    }
    public int getUnNum(char[] chars,int i){
        if(i>=chars.length) return 0;
        while(i<chars.length && chars[i]>='0' && chars[i]<='9' ){
            i++;
        }
        return i;
    }
}