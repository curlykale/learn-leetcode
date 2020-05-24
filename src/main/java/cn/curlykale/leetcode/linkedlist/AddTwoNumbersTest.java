package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author maxp
 * @date 2020/05/22
 */
public class AddTwoNumbersTest {
    private Logger logger = Logger.getLogger("AddTwoNumbersTest");

    @Test
    public void testSortList() {
        ListNode head = new ListNode(9);
        head.next = new ListNode(6);
        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(5);
        ListNode listNode = addTwoNumbers(head, head1);
        String sb = ListUtil.nodeString(listNode);
        logger.info(sb);
    }

    /**
     * 思路：同时遍历两个链表，然后进行数字相加，要特别注意：位数不一样的情况、有一个为空的情况、进位的情况
     *
     * 测试用例	说明
     * l1=[0,1]l1=[0,1]，l2=[0,1,2]l2=[0,1,2]	当一个列表比另一个列表长时
     * l1=[]l1=[]，l2=[0,1]l2=[0,1]	当一个列表为空时，即出现空列表
     * l1=[9,9]l1=[9,9]，l2=[1]l2=[1]	求和运算最后可能出现额外的进位，这一点很容易被遗忘
     *
     *
     * @param l1 ListNode1
     * @param l2 ListNode2
     * @return node
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode p = root;
        int curr = 0;
        while (l1 != null || l2 != null || curr != 0) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sumVal = l1val + l2val + curr;
            curr = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            p.next = sumNode;
            p = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

}