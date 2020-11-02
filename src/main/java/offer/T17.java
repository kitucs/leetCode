package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        int []result =   solution17.printNumbers(4);
        System.out.println(Arrays.toString(result));
    }
}
class Solution17 {
    int[] result = {};
    StringBuilder stringBuilder = new StringBuilder();
    List<String> arrayList = new ArrayList();
    public int[] printNumbers(int n) {
        if(n==0){
//            System.out.println("[]");
            return null;
        }
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
//        System.out.print("[1,2,3,4,5,6,7,8,9");
        for(int i=2;i<=n;i++){
            for (int j = 1; j <= 9 ; j++) {
                stringBuilder.append(String.valueOf(j));
                dfs(i-1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
//        System.out.print("]");
        return arrayList.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void dfs(int depth){
        if(depth==0){
            arrayList.add(stringBuilder.toString());
//            System.out.print(","+stringBuilder);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            stringBuilder.append(String.valueOf(i));
            dfs(depth-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}