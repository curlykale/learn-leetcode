package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author maxp
 * @date 2020/05/16
 */
public class ReverseTest {
    private Logger logger = Logger.getLogger("ReverseTest");

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = reverseList(head);
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(">");
            listNode = listNode.next;
        }
        logger.info(sb.toString());
    }

    /**
     * 1->2->3->4->5->NULL
     * 5->4->3->2->1->NULL
     *
     * @param head listNode
     * @return listNode
     */
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        return preNode;
    }
}
