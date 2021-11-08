package leecode;

public class Demo19 {
//

    public static void main(String[] args) {
        new Demo19().removeNthFromEnd(DemoUtils.makeListNode(new int[]{1, 2, 3, 4, 5}), 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] nodes = new ListNode[30];
        int size = 0;
        while (head != null) {
            nodes[size++] = head;
            head = head.next;
        }
        if (size -n - 1 < 0){
            return nodes[1];
        }
        nodes[size - n - 1].next = nodes[size - n + 1];
        return nodes[0];
    }

}