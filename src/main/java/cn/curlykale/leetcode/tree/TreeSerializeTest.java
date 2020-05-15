package cn.curlykale.leetcode.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author maxp
 * @date 2020/05/14
 */
public class TreeSerializeTest {
    private Logger logger = Logger.getLogger("ValidBSTTest");


    @Test
    public void testRob() {
        Integer[] nums = new Integer[]{5, 1, 6};
        TreeNode td = TreeUtil.array2tree(nums, 0);

        TreeSerialize ts = new TreeSerialize();
        String s = ts.serialize(td);
        logger.info(s);
        TreeNode treeNode = ts.deserialize(s);
        List<Integer> list = new ArrayList<>();
        TreeUtil.tree2array(treeNode, list, 0);
        logger.info(JSON.toJSONString(list));
    }

}
