package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author maxp
 * @date 2020/05/17
 */
public class MergeListTest {

    private Logger logger = Logger.getLogger("MergeListTest");

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode listNode = mergeTwoLists(head, head1);
//        ListNode listNode2 = mergeTwoLists2(head, head1);
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(">");
            listNode = listNode.next;
        }
        logger.info(sb.toString());
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

}
