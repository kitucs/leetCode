package linkedList;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){val=x;}
    public static ListNode createList(int[] nums){
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return head.next;
    }
    public static void printList(ListNode head){
        System.out.println("ListNode:");
        while (head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }
}