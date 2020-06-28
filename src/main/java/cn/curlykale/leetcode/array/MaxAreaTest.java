package cn.curlykale.leetcode.array;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author maxp
 * @date 2020/06/28
 */
public class MaxAreaTest {
    private Logger logger = Logger.getLogger("MaxAreaTest");

    @Test
    public void testSearch() {
        int[] nums = new int[]{1, 8};
        int sum = maxArea(nums);
        String val = String.valueOf(sum);
        logger.info(val);
    }

    private int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
