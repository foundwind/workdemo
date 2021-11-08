package leecode;

public class DemoUtils {


    public static ListNode makeListNode(int[] ints) {
        ListNode node = new ListNode();
        ListNode mid = node;
        for (int i : ints) {
            mid.next = new ListNode(i);
            mid = mid.next;
        }
        return node.next;
    }

    public static <T> T[] getList(T... t) {
        return t;
    }


}