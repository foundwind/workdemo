package leecode;

public class Demo86 {
//

    public static void main(String[] args) {
        new Demo86().partition(DemoUtils.makeListNode(new int[]{1, 4, 3, 2, 5, 2}), 3);
    }

    public ListNode partition(ListNode head, int x) {
        // 这个是return
        ListNode returnNode = new ListNode();
        ListNode concatNode = returnNode;

        ListNode headCache = new ListNode();
        ListNode headPre = new ListNode();
        headPre.next = head;

        boolean fistChange = false;
        // 拼起来，否则拼到后面去
        while (head != null) {
            if (head.val < x) {
                ListNode cache = head;
                headPre.next = head.next;
                head = headPre.next;
                // head去后面一格
                cache.next = null;
                concatNode.next = cache;
                concatNode = cache;
            } else {
                // 第一个不变头部
                if (!fistChange) {
                    headCache.next = head;
                    fistChange = true;
                }
                headPre = head;
                head = head.next;
            }
        }
        concatNode.next = headCache.next;
        return returnNode.next;
    }
}