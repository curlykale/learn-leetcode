package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author maxp
 * @date 2020/05/28
 */
public class FindDuplicateTest {

    private Logger logger = Logger.getLogger("MaxPathSumTest");


    @Test
    public void testRob() {
        int[] nums = new int[]{3, 3, 1, 2};
        int td = findDuplicate(nums);
        String val = String.valueOf(td);
        logger.info(val);
    }

    /**
     * 题目：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数.如果数字超出n，不能用二分法
     * 思路：二分法
     * 重复数的值落在 [1, n]，所以可以 对 [1, n] 进行二分查找。mid = (1 + n) / 2，它要么落在 [1, mid] ， 要么落在 [mid + 1, n]
     * 遍历原数组，统计小于等于 mid 的元素的个数，记为 k。
     * 如果 k > mid，说明有超过 mid 个数的值落在区间 [1, mid] ，但该区间最多只能有 mid 个不同的数，说明重复的数落在 [1, mid]；
     * 如果 k <= mid ，则说明重复数落在 [mid + 1, n]
     *
     * @param nums int数组
     * @return 重复的数字
     */
    private int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length;
        int ret = -1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
                ret = mid;
            }
        }
        return ret;
    }

}
