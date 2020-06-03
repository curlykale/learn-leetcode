package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author maxp
 * @date 2020/06/03
 */
public class SearchRotatedTest {
    private Logger logger = Logger.getLogger("SearchRotatedTest");


    @Test
    public void testSearch() {
        int[] nums = new int[]{4, 5, 6, 7, 1, 2, 3};
        int target = 7;
        int td = search(nums, target);
        String val = String.valueOf(td);
        logger.info(val);
    }

    /**
     * 思路：二分法
     * 二分之后，一段有序、一段无序，判断target位于哪一部分，然后不断二分查找
     * @param nums int数组
     * @param target 查找的数字
     * @return 查找的数字数组下标
     */
    private int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }
}
