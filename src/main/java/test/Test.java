package test;

public class Test {
    public static void main(String[] args) {
        int[] x= {0};
        test(x);
        System.out.println(x[0]);

    }
    public static void test(int[] x){
        x[0]=1;
    }
}
