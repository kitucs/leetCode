package offer;

public class T9 {
    public static void main(String[] args) {
        int value = 0;
        CQueue obj = new CQueue();
        obj.appendTail(value);
        int param_2 = obj.deleteHead();
    }
}
class CQueue {

    public CQueue() {

    }
    //队列尾部插入整数
    public void appendTail(int value) {

    }
    //在队列头部删除整数
    public int deleteHead() {
        return 0;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
