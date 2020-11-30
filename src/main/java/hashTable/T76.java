package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 没有考虑重复字符
 */
public class T76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String re = solution76.minWindow("ab","a");
        System.out.println(re);
    }
}
class Solution76 {
    public String minWindow(String s, String t) {
        int need=0;
        int minLen=s.length()+1;
        int resultLeft = 0;
        Map<Character,Integer> needMap = new HashMap<>();
        Map<Character,Integer> haveMap = new HashMap<>();

        //needMap
        for(char ti:t.toCharArray()){
            if( !needMap.containsKey(ti) ){
                needMap.put( ti , 0 );
            }
            needMap.put( ti , needMap.get(ti)+1 );
            need++;
        }

        int left=0,right=0;
        while(right<=s.length()){
            if(right==s.length()){
                //对边界判断，此时若need==0，还需要进入下面的判断
                if(need>0)
                    break;
            }else if(!needMap.containsKey(s.charAt(right)) && need>0 ){
                // 非关键字母跳过
                right++;
                continue;
            }

            if(need>0){
                // right ++
                char nowCh = s.charAt(right);

                if( !haveMap.containsKey(nowCh) ){
                    haveMap.put( nowCh , 0 );
                }
                haveMap.put( nowCh , haveMap.get(nowCh)+1 );

                if(haveMap.get(nowCh)<=needMap.get(nowCh)){
                    need--;
                }

                right++;
            }else if(need==0){
                // left ++
                //1、找到left
                while(left<s.length() && !needMap.containsKey(s.charAt(left))){
                    left++;
                }
                if (right-left < minLen){
                    minLen = right - left;
                    resultLeft = left;
                }

                //2、更新map和need
                char temp = s.charAt(left);
                if(haveMap.get(temp).equals(needMap.get(temp))){
                    need++;
                }
                haveMap.put(temp, haveMap.get(temp)-1);
                //3、更新left
                left++;
            }
        }

        if(minLen==s.length()+1){
            return "";
        }
        return s.substring(resultLeft,resultLeft+minLen);
    }

}