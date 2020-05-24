package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/comments/
 *
 * @author maxp
 * @date 2020/05/19
 */
public class HasCycleTest {
    private Logger logger = Logger.getLogger("HasCycleTest");

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        ListNode node = new ListNode(9);
        node.next = new ListNode(3);
        head.next.next = node;
        node.next.next = head.next;
        boolean hasCycle = hasCycle(head);
        String sb = String.valueOf(hasCycle);
        logger.info(sb);
    }

    /**
     * 思路：1.快慢指针,时间复杂度O(n),空间复杂度 O(1);2.set集合存放node节点,时间复杂度O(n),空间复杂度 O(n)
     *
     * @param head listNode
     * @return boolean
     */
    private boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
