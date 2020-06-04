package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author maxp
 * @date 2020/06/03
 */
public class FindMedianTest {
    private Logger logger = Logger.getLogger("FindMedianTest");


    @Test
    public void testSearch() {
        int[] nums1 = new int[]{4, 5, 6, 7};
        int[] nums2 = new int[]{1, 2, 3};
        double td = findMedianSortedArrays(nums1, nums2);
        String val = String.valueOf(td);
        logger.info(val);
    }

    /**
     * 思路：
     * 非最佳
     * 用 aStart 和 bStart 分别表示当前指向 A 数组和 B 数组的位置。
     * 如果 aStart 还没有到最后并且此时 A 位置的数字小于 B 位置的数组，也就是aStart＜m&&A[aStart]< B[bStart], AA后移。
     * 如果 B 数组此刻已经没有数字了，继续取数字 B[ bStart ]，则会越界，所以判断下 bStart 是否大于数组长度了，也就是Start＜m&&(bStart) >= n， A后移 。
     * 其它情况下B数组后移，直到移到len/2, left、right分别存储中间的两个数，然后判断len奇偶数，根据left、right值计算中位数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1;
        int right = -1;
        int aStart = 0;
        int bStart = 0;
        int tmp = 2;
        for (int i = 0; i <= len / tmp; i++) {
            left = right;
            boolean b = aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart]);
            if (b) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if (len % tmp == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
