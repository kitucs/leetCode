package offer;

import java.util.HashMap;
import java.util.Map;

public class T50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        char c = solution50.firstUniqChar("abaccdeff");
        System.out.println(c);
    }
}
class Solution50 {
    public char firstUniqChar(String s) {
        char[]chars= s.toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(char c : chars){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1 );
            }else{
                map.put(c,1);
            }
        }
        for(char c : chars){
            if(map.containsKey(c)){
                if(map.get(c)==1)
                    return c;
            }
        }
        return ' ';
    }
}