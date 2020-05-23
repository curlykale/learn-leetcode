package cn.curlykale.leetcode.linkedlist;

/**
 * 链表工具类
 *
 * @author maxp
 * @date 2020/05/23
 */
class ListUtil {
    private ListUtil() {

    }

    static String nodeString(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(">");
            listNode = listNode.next;
        }
        return sb.toString();
    }
}
