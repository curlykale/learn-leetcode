package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author maxp
 * @date 2020/05/18
 */
public class IntersectionNodeTest {

    private Logger logger = Logger.getLogger("IntersectionNodeTest");

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        ListNode node = new ListNode(9);
        node.next = new ListNode(3);
        head.next.next =  node;
        ListNode head1 = new ListNode(5);
        head1.next = node;
        ListNode listNode = getIntersectionNode(head, head1);
        assert listNode.val == 9;
        logger.info(String.valueOf(listNode.val));
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB) {
            preA = preA == null ? headB : preA.next;
            preB = preB == null ? headA : preB.next;
        }
        return preA;
    }

}
