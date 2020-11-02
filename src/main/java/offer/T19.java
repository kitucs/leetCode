package offer;

public class T19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        String s = s = "mississippi";
        String p = "mis*is*p*.";
        boolean re = solution19.isMatch(s,p);
        System.out.println(re);
    }

}
class Solution19 {
    public boolean isMatch(String s, String p) {
        int i=0,j=0;
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        while(i<chars.length && j<charp.length){
            if(charp[j]=='.'){
                // .*
                if(j<charp.length-1 && charp[j+1]=='*'){
                    return true;
                }else{
                    // .
                    i++;
                    j++;
                }
            }else if(charp[j]>='a' && charp[j]<='z' ){
                // a*
                if(j<charp.length-1 && charp[j+1]=='*'){
                    while(i<chars.length && charp[j]==chars[i]){
                        i++;
                    }
                    j+=2;
                }else{
                    // a
                    if(charp[j]==chars[i]){
                        i++;
                        j++;
                    }else{
                        return false;
                    }
                }

            }
        }
        if(i<chars.length || j<charp.length){
            return false;
        }else{
            return true;
        }


    }
}