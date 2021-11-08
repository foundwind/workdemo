package leecode;

public class Demo24 {
//

    public static void main(String[] args) {
        new Demo24().swapPairs(DemoUtils.makeListNode(new int[]{1, 2, 3, 4, 5, 6}));
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;

    }
}