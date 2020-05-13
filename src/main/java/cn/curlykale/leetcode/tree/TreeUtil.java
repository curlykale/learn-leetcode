package cn.curlykale.leetcode.tree;

import java.util.List;

/**
 * @author maxp
 * @date 2020/05/13
 */
class TreeUtil {
    private TreeUtil() {
    }

    /**
     * 树 -》数组
     *
     * @param treeNode 树
     * @param trees    数组
     * @param i        起始索引
     */
    static void tree2array(TreeNode treeNode, List<Integer> trees, int i) {
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
    static TreeNode array2tree(int[] trees, int num) {
        TreeNode treeNode = null;
        if (num < trees.length) {
            treeNode = new TreeNode(trees[num]);
            treeNode.left = array2tree(trees, 2 * num + 1);
            treeNode.right = array2tree(trees, 2 * num + 2);
        }
        return treeNode;
    }


    static TreeNode array2tree(Integer[] trees, int num) {
        TreeNode treeNode = null;
        if (num < trees.length) {
            if (trees[num] == null) {
                return null;
            }
            treeNode = new TreeNode(trees[num]);
            treeNode.left = array2tree(trees, 2 * num + 1);
            treeNode.right = array2tree(trees, 2 * num + 2);
        }
        return treeNode;
    }
}
