package cn.curlykale.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * 单调栈
 *
 * @author maxp
 * @date 2020/04/29
 */

public class SingleStack {
    private static Logger logger = Logger.getLogger("SingleStack");
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        int[] nges = nextGreaterElement(nums);
        logger.info(JSON.toJSONString(nges));
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] dts = dailyTemperatures(temperatures);
        logger.info(JSON.toJSONString(dts));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.empty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            ans[i] = s.empty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return ans;
    }

    private static int[] nextGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums[i]) {
                s.pop();
            }
            ans[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return ans;
    }
}
