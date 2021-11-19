package leecode;

public class Demo83 {
//

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cache = new ListNode();
        cache.next = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return cache.next;
    }

}