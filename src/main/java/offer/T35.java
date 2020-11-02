package offer;

public class T35 {
    public static void main(String[] args) {
        Solution35 solution35 =new Solution35();
//        solution35.copyRandomList();
    }
}
class Solution35 {
    public Node copyRandomList(Node head) {
        return null;

    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}