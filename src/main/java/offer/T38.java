package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        solution38.permutation("abb");
    }
}
class Solution38 {
    char[] temp;
    ArrayList<String> resultList = new ArrayList<>();
    public String[] permutation(String s) {
        temp = s.toCharArray();
        go(0);

        String[] result = new String[resultList.size()];
        int i=0;
        for(String re:resultList){
            result[i++] = re;
        }
        return result;
    }
    //x --> 当前指针
    public void go(int x){
        if(x==temp.length){
            StringBuilder stringBuilder = new StringBuilder();
            for(char tempi:temp){
                stringBuilder.append(tempi);
            }
            resultList.add(stringBuilder.toString());
            System.out.println(stringBuilder.toString());
        }
        Set<Character> myset = new HashSet<>();
        for (int i = x; i < temp.length; i++) {
            //只和各种char交换一次
            if(myset.contains(temp[i])){
                continue;
            }
            myset.add(temp[i]);
            swap(x,i);
            go(x+1);
            swap(x,i);
        }
    }
    public void swap(int i,int j){
        char tempchar = temp[i];
        temp[i]=temp[j];
        temp[j]=tempchar;
    }
}