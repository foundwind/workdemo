package leecode;

public class Demo82 {
//

    public static void main(String[] args) {
//        new Demo82().deleteDuplicates(DemoUtils.makeListNode(new int[]{1, 2, 3, 3, 4, 4, 5}));
        String a = null;
        new Demo82().invoke(null,new Object[]{1},new Object[]{1},new Object[]{1},2,4,6);
    }

    void invoke(Object obj, Object... args) {
        System.out.println("1");
    }

    void invoke(String s, Object obj, Object... args) {
        System.out.println("2");
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode first = new ListNode();
        first.next = head;
        ListNode left = first;
        ListNode right = first.next.next;
        boolean onlyFlag = true;
        while (right != null) {
            if (left.next.val == right.val) {
                right = right.next;
                onlyFlag = false;
            } else {
                if (onlyFlag) {
                    left = left.next;
                    right = right.next;
                } else {
                    left.next = right;
                    right = right.next;
                }
                onlyFlag = true;
            }
        }
        if (!onlyFlag) {
            left.next = null;
        }

        return first.next;

    }

}