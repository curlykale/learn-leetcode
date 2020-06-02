package cn.curlykale.leetcode.search;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author maxp
 * @date 2020/06/02
 */
public class SearchRangeTest {
    private Logger logger = Logger.getLogger("SearchRangeTest");


    @Test
    public void testRob() {
        int[] nums = new int[]{3, 3, 3, 3};
        int target = 3;
        int[] td = searchRange(nums, target);
        String val = JSON.toJSONString(td);
        logger.info(val);
    }

    private int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ret[0] = i;
                break;
            }
        }
        if (ret[0] == -1) {
            return ret;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ret[1] = i;
                break;
            }
        }
        return ret;
    }
}
