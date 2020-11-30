package hashTable;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

public class T49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List list:lists){
            System.out.println(list);
        }
    }
}
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int[] countNum = new int[26];
        for(String str:strs){
            Arrays.fill(countNum,0);
            for(char ch:str.toCharArray()){
                countNum[ch-'a'] += 1;
            }
            // int[] --> 1,2,3
            StringBuilder key=new StringBuilder("");
            for(int x:countNum){
                key.append(x);
                key.append(",");
            }
            if(!map.containsKey(key.toString())){
                map.put(key.toString(),new ArrayList<String>());
            }
            map.get(key.toString()).add(str);
        }
        return new ArrayList<>(map.values());

    }
}