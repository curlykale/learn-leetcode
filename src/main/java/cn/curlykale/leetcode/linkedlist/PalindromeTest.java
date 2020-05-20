package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author maxp
 * @date 2020/05/20
 */
public class PalindromeTest {
    private Logger logger = Logger.getLogger("PalindromeTest");

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        ListNode node = new ListNode(6);
        node.next = new ListNode(1);
        head.next.next = node;
        boolean hasCycle = isPalindrome(head);
        logger.info(String.valueOf(hasCycle));
    }

    /**
     * 思路：1.快慢指针获取链表中点，反转前半部分链表，比较反转后的连表和后半部分连表。时间复杂度O(n),空间复杂度 O(n);
     *
     * @param head listNode
     * @return boolean
     */
    private boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 反转后的前半部分链表
        ListNode pre = null;
        ListNode temp = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = temp;
            temp = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
