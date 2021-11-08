package leecode;

public class Demo25 {
//

    public static void main(String[] args) {
        new Demo25().reverseKGroup(DemoUtils.makeListNode(new int[]{1, 2, 3, 4, 5}), 3);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;

        ListNode[] nodes = new ListNode[k];
        while (true) {
            int num = 0;
            boolean out = false;
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    temp = reverse(temp, nodes, num, false);
                    out = true;
                    break;
                }
                nodes[i] = head;
                head = head.next;
                num++;
            }
            if (out) break;
            temp = reverse(temp, nodes, num, true);
        }
        return dummyHead.next;

    }

    private ListNode reverse(ListNode temp, ListNode[] nodes, int num, boolean b) {
        if (num == 0) return temp;
        if (!b) {
            temp.next = nodes[0];
            return temp;
        }
        temp.next = nodes[num - 1];
        for (int i = num - 1; i > 0; i--) {
            nodes[i].next = nodes[i - 1];
        }
        temp = nodes[0];
        temp.next = null;
        return temp;
    }
}