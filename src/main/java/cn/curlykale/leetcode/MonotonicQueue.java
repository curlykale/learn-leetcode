package cn.curlykale.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 单调队列
 *
 * @author maxp
 * @date 2020/04/29
 */
public class MonotonicQueue {
    private static Logger logger = Logger.getLogger("MonotonicQueue");

    private static class SingleQueue {
        private ArrayDeque<Integer> data = new ArrayDeque<>();

        private void push(int n) {
            while (!data.isEmpty() && data.peek() < n) {
                data.remove();
            }
            data.add(n);
        }

        private int max() {
            return data.element();
        }

        private void pop(int n) {
            if (!data.isEmpty() && data.peek() == n) {
                data.poll();
            }
        }

    }


    private static List<Integer> maxSlidingWindow(int[] nums, int k) {
        SingleQueue window = new SingleQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //先填满窗口的前 k - 1
            // 窗口向前滑动
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> mws = maxSlidingWindow(nums, k);
        logger.info(JSON.toJSONString(mws));
    }
}
