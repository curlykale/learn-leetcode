package cn.curlykale.leetcode.twosum;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kale
 * @since 2019-03-31
 */
public class TwoSumTest {
    private static Logger logger = Logger.getLogger("TwoSumTest");

    @Test
    public void twoSumTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Long start = System.currentTimeMillis();
        int[] result = twoSum(nums, target);
        Long end = System.currentTimeMillis();
        long ret = end - start;
        if (logger.isLoggable(Level.INFO)) {
            logger.info("耗时：{}" + ret);
            logger.info(JSON.toJSONString(result));
        }

    }


    /**
     * https://leetcode-cn.com/problems/two-sum/
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums   数组
     * @param target 和
     * @return int数组
     */
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(target - nums[i]);
            if (v != null && v > i) {
                ret[0] = i;
                ret[1] = v;
                return ret;
            }
        }
        return ret;
    }

}
