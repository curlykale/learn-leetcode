package cn.curlykale.leetcode.tree;

import org.junit.Test;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author maxp
 * @date 2020/05/13
 */
public class ValidBstTest {
    private Logger logger = Logger.getLogger("ValidBSTTest");


    @Test
    public void testRob() {
        Integer[] nums = new Integer[]{5, 1, 6};
        TreeNode td = TreeUtil.array2tree(nums, 0);
        boolean bst = isValidBST(td);
        logger.info(String.valueOf(bst));
    }

    private boolean isValidBST(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!treeNodeStack.empty() || root != null) {
            while (root != null) {
                treeNodeStack.push(root);
                root = root.left;
            }
            root = treeNodeStack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;

        }
        return true;
    }
}
