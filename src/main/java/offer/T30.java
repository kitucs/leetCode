package offer;

import java.util.Stack;

public class T30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();

    }
}
class MinStack {
    Stack s1 = null;//保存各层值
    Stack s2 = null;//保存各层最小值
    public MinStack() {
         s1 = new Stack<Integer>();
         s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.empty()){
            s2.push(x);
        }else{
            int y = (int)(s2.peek());
            int min = y<x ? y:x;
            s2.push(min);
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return (int) s1.peek();

    }

    public int min() {
        return (int) s2.peek();

    }
}