package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author maxp
 * @date 2020/05/22
 */
public class DetectCycleTest {
    private Logger logger = Logger.getLogger("DetectCycleTest");

    @Test
    public void testSortList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(5);
        head1.next.next = head.next;
        head.next.next = head1;
        ListNode listNode = detectCycle2(head);
        if (listNode != null) {
            logger.info(String.valueOf(listNode.val));
        }
    }

    /**
     * 思路：借助hash表 判断环的位置
     *
     * @param head ListNode
     * @return listNode
     */

    private ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * 快慢指针判断是否存在环，存在返回快慢指针相遇节点
     *
     * @param head ListNode
     * @return listNode
     */
    private ListNode getMeet(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    /**
     * Floyd 的算法被划分成两个不同的 阶段 。在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 null 并退出。否则，用 相遇节点 来找到环的入口。
     * 首先我们初始化额外的两个指针： ptr1 ，指向链表的头， ptr2 指向相遇点。然后，我们每次将它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点
     *
     * @param head ListNode
     * @return listNode
     */
    private ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode meet = getMeet(head);
        if (meet == null) {
            return null;
        }

        ListNode part1 = head;
        ListNode part2 = meet;
        while (part1 != part2) {
            part1 = part1.next;
            part2 = part2.next;
        }
        return part1;
    }

}
