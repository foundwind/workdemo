package leecode;

public class Demo61 {
//

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        //找出size
        int size = 1;
        ListNode cache = head;
        ListNode tail = null;
        while (cache.next != null) {
            cache = cache.next;
            size++;
        }
        tail = cache;
        cache = head;

        int point = k % size;

        if (point == 0) return head;

        for (int i = size - point; i > 1; i--) {
            cache = cache.next;
        }
        ListNode result = cache.next;
        cache.next = null;
        tail.next = head;
        return result;
    }

}