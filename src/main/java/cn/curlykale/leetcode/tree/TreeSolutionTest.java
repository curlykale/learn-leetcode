package cn.curlykale.leetcode.tree;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 二叉树
 *
 * @author maxp
 * @date 2020/04/30
 */
public class TreeSolutionTest {
    private Logger logger = Logger.getLogger("TreeSolution");

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    @Test
    public void testCovertTree() {
        int[] nums = new int[]{-10, -3, 0, 5, 9, 11};
        TreeNode td = array2tree(nums, 0);
        Integer[] trees = treeArray(td);
        logger.info(JSON.toJSONString(trees));
    }


    @Test
    public void testMaxDepthTree() {
        int[] nums = new int[]{-10, -3, 0, 5, 9, 11};
        TreeNode treeNode = sortedArrayToBST(nums);
        int maxDepth = maxDepth(treeNode);
        logger.info(String.valueOf(maxDepth));
    }

    @Test
    public void testMirrorTree() {
        int[] nums = new int[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode td = array2tree(nums, 0);
        TreeNode treeNode = mirrorTree(td);
        Integer[] trees = treeArray(treeNode);
        logger.info(JSON.toJSONString(trees));
    }

    private Integer[] treeArray(TreeNode treeNode) {
        List<Integer> trees = new ArrayList<>();
        tree2array(treeNode, trees, 0);
        return trees.toArray(new Integer[trees.size()]);
    }


    @Test
    public void testMergeTrees() {
        int[] nums1 = new int[]{1, 3, 2, 5};
        int[] nums2 = new int[]{2, 1, 3, 0, 4, 0, 7};
        TreeNode treeNode = mergeTrees(array2tree(nums1, 0), array2tree(nums2, 0));
        Integer[] trees = treeArray(treeNode);
        logger.info(JSON.toJSONString(trees));
    }

    private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     * <p>
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     * <p>
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
     *
     * @param root treeNode
     * @return treeNode
     */
    private TreeNode mirrorTree(TreeNode root) {
        if (null != root) {
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
        }
        return root;
    }

    /**
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * <p>
     * 例如：
     * <p>
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
     *
     * @param root treenode
     * @return 最大深度
     */
    private int maxDepth(TreeNode root) {
        int num = 0;
        if (null != root) {
            num = num + 1;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            num = num + Math.max(left, right);
        }
        return num;
    }

    /**
     * 树 -》数组
     *
     * @param treeNode 树
     * @param trees    数组
     * @param i        起始索引
     */
    private void tree2array(TreeNode treeNode, List<Integer> trees, int i) {
        if (null != treeNode) {
            trees.add(treeNode.val);
            tree2array(treeNode.left, trees, 2 * i + 1);
            tree2array(treeNode.right, trees, 2 * i + 2);
        }
    }

    /**
     * 数组 -》 树
     *
     * @param trees 数组
     * @param num   起始做引
     * @return 树
     */
    private TreeNode array2tree(int[] trees, int num) {
        TreeNode treeNode = null;
        if (num < trees.length) {
            treeNode = new TreeNode(trees[num]);
            treeNode.left = array2tree(trees, 2 * num + 1);
            treeNode.right = array2tree(trees, 2 * num + 2);
        }
        return treeNode;
    }

    /**
     * 给定有序数组: [-10,-3,0,5,9],
     * <p>
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
     *
     * @param nums 有序数组
     * @return 二叉树
     */
    private TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        return handleTree(nums, left, nums.length);
    }

    private TreeNode handleTree(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = handleTree(nums, left, mid);
        treeNode.right = handleTree(nums, mid + 1, right);
        return treeNode;
    }
}
