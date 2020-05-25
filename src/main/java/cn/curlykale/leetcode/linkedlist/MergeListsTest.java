package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author maxp
 * @date 2020/05/25
 */
public class MergeListsTest {

    private Logger logger = Logger.getLogger("MergeKListsTest");

    @Test
    public void testSortList() {
        ListNode[] lists = new ListNode[2];
        ListNode head = new ListNode(3);
        head.next = new ListNode(6);
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        lists[0] = head;
        lists[1] = head1;
        ListNode listNode = mergeKLists(lists);
        String sb = ListUtil.nodeString(listNode);
        logger.info(sb);
    }


    /**
     * 思路： 分治算法
     * 先把list拆分陈两两的链表，然后两两合并
     *
     * @param lists ListNode list
     * @return 合并后的listNode
     */
    private ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
