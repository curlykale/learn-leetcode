package cn.curlykale.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 全排列
 *
 * @author maxp
 * @date 2020/04/28
 */
public class FullRank {
    private static Logger logger = Logger.getLogger("FullRank");
    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 3};
        List<List<Integer>> permute = permute(nums);
        logger.info(JSON.toJSONString(permute));

    }

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     *
     * @param nums int数组
     * @return 嵌套list
     */
    private static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums int数组
     * @param track 链表list
     */

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            // 排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }


}
