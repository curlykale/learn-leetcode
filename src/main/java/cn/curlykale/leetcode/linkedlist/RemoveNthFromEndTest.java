package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author maxp
 * @date 2020/05/23
 */
public class RemoveNthFromEndTest {
    private Logger logger = Logger.getLogger("RemoveNthFromEndTest");

    @Test
    public void testRemoveNthFromEnd() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        int n = 3;
        ListNode listNode = removeNthFromEnd(head, n);
        String sb = ListUtil.nodeString(listNode);
        logger.info(sb);
    }



    /**
     * 思路：使用map存储节点和节点索引，然后根据不同情况（最后一个节点、第一个节点、除第一个和最后一个之外的节点）判断删除元素
     * 注意：边界条件要注意：第一个节点、最后一个节点、n==1
     *
     * @param head listNode
     * @param n    倒数数字
     * @return listNode
     */
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        Map<Integer, ListNode> map = new HashMap<>(16);
        ListNode root = head;
        int len = 1;
        while (root != null) {
            map.put(len++, root);
            root = root.next;
        }

        int size = map.size();
        // 此处注意：要先判断n==size的情况，否则n=1,size=1的情况下执行map.get(size - 1).next = null;会出错
        if (n == size) {
            head = head.next;
        } else if (n == 1) {
            map.get(size - 1).next = null;
        } else {
            ListNode p = map.get(size - n);
            p.next = map.get(size - n + 2);
        }
        return head;
    }
}
