package leecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo21 {
//

    public static void main(String[] args) {


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cache = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cache.next = l1;
                l1 = l1.next;
            } else {
                cache.next = l2;
                l2 = l2.next;
            }
            cache = cache.next;
        }
        if (l1 != null) {
            cache.next = l1;
        } else {
            cache.next = l2;
        }
        return head.next;
    }


}