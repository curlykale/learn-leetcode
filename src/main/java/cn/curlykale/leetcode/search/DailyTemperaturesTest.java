package cn.curlykale.leetcode.search;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author maxp
 * @date 2020/06/24
 */
public class DailyTemperaturesTest {
    private Logger logger = Logger.getLogger("DailyTemperaturesTest");

    @Test
    public void testSearch() {
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] sum = dailyTemperatures(nums);
        String val = JSON.toJSONString(sum);
        logger.info(val);
    }

    private int[] dailyTemperatures(int[] nums) {
        int[] ans = new int[nums.length];
        // 双端队列，支持在两端插入和移除元素
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int temperature = nums[i];
            while (!stack.isEmpty() && temperature > nums[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
