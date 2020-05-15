package cn.curlykale.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maxp
 * @date 2020/05/14
 */
class TreeSerialize {

    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return seDfs(root, sb);
    }

    private String seDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            seDfs(root.left, sb);
            seDfs(root.right, sb);
        }
        return sb.toString();
    }

    TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> li = new LinkedList<>(Arrays.asList(strArray));
        return desDfs(li);
    }

    private TreeNode desDfs(List<String> li) {
        String d = "null";
        if (d.equals(li.get(0))) {
            li.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(li.get(0)));
        li.remove(0);
        node.left = desDfs(li);
        node.right = desDfs(li);
        return node;
    }

}
