package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author maxp
 * @date 2020/05/22
 */
public class SortListTest {
    private Logger logger = Logger.getLogger("SortListTest");

    @Test
    public void testSortList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(3);
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(6);
        head1.next.next = head2;
        head.next.next = head1;
        ListNode listNode = sortList(head);
        String sb = ListUtil.nodeString(listNode);
        logger.info(sb);
    }

    /**
     * 思路：
     * 切分链表
     * 双路归并
     *
     * @param head ListNode
     * @return listNode
     */

    private ListNode sortList(ListNode head) {
        // dumpHead 存储最后的结果
        ListNode dumpHead = new ListNode(Integer.MIN_VALUE);
        dumpHead.next = head;
        ListNode p = head;
        // 计算链表长度
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        // 循环切割排序合并node，1->2->4->8...
        for (int i = 1; i < length; i <<= 1) {
            ListNode cur = dumpHead.next;
            ListNode tail = dumpHead;
            while (cur != null) {
                ListNode left = cur;
                // 截取left，返回剩下的给right
                ListNode right = cut(cur, i);
                // 截取right，返回剩下的给cur
                cur = cut(right, i);
                // 比较合并
                tail.next = merge(left, right);
                // 遍历tail指针到尾部节点
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dumpHead.next;
    }

    /**
     * 切分listNode返回剩余listNode
     *
     * @param head 原始listNode
     * @param n    切分数量
     * @return 切分剩余的ListNode
     */
    private ListNode cut(ListNode head, int n) {
        if (n <= 0 || head == null) {
            return null;
        }
        ListNode p = head;
        // 切分n个节点只需要执行n-1次next
        n = n - 1;
        while (n-- > 0 && p != null) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        ListNode next = p.next;
        // 切分node
        p.next = null;
        return next;
    }

    /**
     * 合并两个listNode
     *
     * @param head1 listNode1
     * @param head2 listNode2
     * @return 合并后的listNode
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        //存储合并后的node
        ListNode dumpNode = new ListNode(Integer.MIN_VALUE);
        ListNode p = dumpNode;
        // 比较合并节点
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        // 处理head1和head2长度不相等的情况
        if (head1 != null) {
            p.next = head1;
        } else {
            p.next = head2;
        }

        return dumpNode.next;
    }
}
