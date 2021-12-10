package leecode;

public class Demo92 {
//

    public static void main(String[] args) {
        new Demo92().reverseBetween(DemoUtils.makeListNode(new int[]{1, 2, 3, 4, 5}), 1, 4);
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode cache = head;
        ListNode revertStart = new ListNode();
        revertStart.next = head;

        int dif = right - left;

        // 存放指针
        ListNode[] nodes = new ListNode[dif + 1];

        int index = 0;
        // 先跑几步
        for (int i = 1; i < left; i++) {
            cache = cache.next;
            revertStart = revertStart.next;

        }
        nodes[index++] = cache;

        for (int i = left; i < right; i++) {
            cache = cache.next;
            nodes[index++] = cache;
        }

        cache = cache.next;
        // 如果完全翻转
        if (left == 1) {
            head = nodes[dif];
        }
        revertStart.next = nodes[dif];

        for (int i = dif - 1; i >= 0; i--) {
            nodes[i + 1].next = nodes[i];

        }

        nodes[0].next = cache;
        return head;
    }
}