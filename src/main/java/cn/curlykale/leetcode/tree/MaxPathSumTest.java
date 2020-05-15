package cn.curlykale.leetcode.tree;


import org.junit.Test;

import java.util.logging.Logger;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author maxp
 * @date 2020/05/15
 */
public class MaxPathSumTest {

    private Logger logger = Logger.getLogger("MaxPathSumTest");


    @Test
    public void testRob() {
        Integer[] nums = new Integer[]{-10, -1};
        TreeNode td = TreeUtil.array2tree(nums, 0);
        int sum = maxPathSum(td);
        logger.info(String.valueOf(sum));
    }

    /**
     * 解题思路：
     * 1.获取左右节点的最大值，返回当前节点的单边最大值（即当前节点+左子树/当前节点+右子树）,如果左右子树值为负，则取0（注意边界值）
     * 2.每一次迭代比较更新最大路径和: max(最大路径和, 当前节点值+左子树最大值+右子树最大值)
     */

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxNode(root);
        return maxSum;
    }

    private int maxNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxNode(root.left), 0);
        int rightSum = Math.max(maxNode(root.right), 0);

        int newPathSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, newPathSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
