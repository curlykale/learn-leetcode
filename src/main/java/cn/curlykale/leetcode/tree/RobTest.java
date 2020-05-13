package cn.curlykale.leetcode.tree;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author maxp
 * @date 2020/05/13
 */
public class RobTest {
    private Logger logger = Logger.getLogger("RobTest");


    @Test
    public void testRob() {
        Integer[] nums = new Integer[]{3, 4, 5, 1, 3, null, 1};
        TreeNode td = TreeUtil.array2tree(nums, 0);
        int rob = rob(td);
        logger.info(String.valueOf(rob));
    }


    private int rob(TreeNode root) {
        int[] result = dfsRob(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 思路：
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     *
     * @param root treeNode
     * @return int[]
     */
    private int[] dfsRob(TreeNode root) {
        int[] num = new int[2];
        if (root == null) {
            return num;
        }
        int[] left = dfsRob(root.left);
        int[] right = dfsRob(root.right);

        num[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        num[1] = left[0] + right[0] + root.val;
        return num;
    }
}
