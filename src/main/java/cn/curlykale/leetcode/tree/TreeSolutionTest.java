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
        return trees.toArray(new Integer[0]);
    }


    @Test
    public void testMergeTrees() {
        int[] nums1 = new int[]{1, 3, 2, 5};
        int[] nums2 = new int[]{2, 1, 3, 0, 4, 0, 7};
        TreeNode treeNode = mergeTrees(array2tree(nums1, 0), array2tree(nums2, 0));
        Integer[] trees = treeArray(treeNode);
        logger.info(JSON.toJSONString(trees));
    }


    @Test
    public void testBST() {
        int[] nums = new int[]{5, 2, 8, 1, 3, 7, 9};
        TreeNode treeNode = convertBST(array2tree(nums, 0));
        Integer[] trees = treeArray(treeNode);
        logger.info(JSON.toJSONString(trees));
    }

    @Test
    public void testPathSum() {
        int[] nums = new int[]{10, 5, -3, 3, 2, 0, 11, 3, -2, 0, 1};
        int sum = 8;
        int num = pathSum(array2tree(nums, 0), sum);
        logger.info(String.valueOf(num));
    }

    @Test
    public void testSymmetric() {
        int[] nums = new int[]{1, 2, 2, 3, 4, 4, 3};
        boolean symmetric = isSymmetric(array2tree(nums, 0));
        logger.info(String.valueOf(symmetric));
    }

    @Test
    public void testDiameter() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int diameter = diameterOfBinaryTree(array2tree(nums, 0));
        logger.info(String.valueOf(diameter));
    }

    @Test
    public void testInorder() {
        int[] nums = new int[]{1, 0, 2, 3};
        List<Integer> list = inorderTraversal(array2tree(nums, 0));
        logger.info(JSON.toJSONString(list));
    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,3,2]
     *
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * @param root treeNode
     * @return list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tList = new ArrayList<>();
        if (root == null) {
            return tList;
        }
        List<Integer> list1 = inorderTraversal(root.left);
        tList.addAll(list1);
        tList.add(root.val);
        List<Integer> list2 = inorderTraversal(root.right);
        tList.addAll(list2);
        return tList;
    }

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * <p>
     *  
     * <p>
     * 示例 :
     * 给定二叉树
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxNum = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxNum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = dfs(root.left);
        int rd = dfs(root.right);
        maxNum = Math.max(ld + rd, maxNum);
        return Math.max(ld, rd) + 1;
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     *  
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     *  
     * <p>
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     *
     * @param root treeNode
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val == rightNode.val) {
            boolean b = symmetric(leftNode.left, rightNode.right);
            boolean c = symmetric(leftNode.right, rightNode.left);
            return b && c;
        }
        return false;
    }

    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * <p>
     * 找出路径和等于给定数值的路径总数。
     * <p>
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     * <p>
     * 示例：
     * <p>
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * 返回 3。和等于 8 的路径有:
     * <p>
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-iii
     */
    private int numbers = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        nodeSum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return numbers;
    }

    public void nodeSum(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            numbers++;
        }
        nodeSum(root.left, sum);
        nodeSum(root.right, sum);
    }


    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * <p>
     *  
     * <p>
     * 例如：
     * <p>
     * 输入: 原始二叉搜索树:
     * 5
     * /   \
     * 2     13
     * <p>
     * 输出: 转换为累加树:
     * 18
     * /   \
     * 20     13
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
     */
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
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
     * 与226题一样
     * https://leetcode-cn.com/problems/invert-binary-tree/
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
